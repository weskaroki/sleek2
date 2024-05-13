package com.wanyeki.restaurantmanagement.ui.theme.screens.orders

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class AllOrderScreen(
    private val orderViewModel: OrderViewModel,
) {
    @Composable
    fun Show() {
        orderViewModel.selectAllScreen()

        val allOrderItems by orderViewModel.allScreenMenuItems
            .collectAsState(initial = emptyList())
        val allOrderNotes by orderViewModel.allScreenNotes
            .map { list -> list.filter { it.second.isNotBlank() && it.second != "_"} }
            .collectAsState(initial = emptyList())

        LazyColumn {
            items(allOrderItems) { CustomerItem(it) }
            items(allOrderNotes) { CustomerNote(it) }
            item{
                val totalPrice = allOrderItems.sumOf { it.menuItem.price * it.number }
                Spacer(Modifier.height(30.dp))
                Text(text = "Total price: $totalPrice", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), style = MaterialTheme.typography.h5)
            }
        }
    }

    @Composable
    fun CustomerItem(item: AllScreenItem) {
        val expanded = remember { mutableStateOf(false) }
        RoundedButtonColumnCard(
            border = BorderStroke(2.dp, MaterialTheme.colors.onSurface),
            onClick = { expanded.value = !expanded.value }
        ) {
            RoundedRowCard{
                Text(text = smartSubstring(item.menuItem.name, 30))
                Text(text = item.number.toString())
            }
            if (expanded.value) {
                RoundedRowCard(
                    modifier = Modifier.padding(8.dp, 0.dp).fillMaxWidth()
                ) {
                    LazyRowFor(items = item.orders) {quantity ->
                        Surface(
                            shape = CircleShape,
                            color = getColorOr(quantity.first),
                            modifier = Modifier.padding(4.dp, 0.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(10.dp, 4.dp),
                                text = quantity.second.toString(),
                                color = MaterialTheme.colors.primary
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun CustomerNote(note: Pair<String, String>) {
        RoundedRowCard(color = getColorOr(note.first)){
            Text(
                modifier = Modifier.padding(16.dp, 8.dp),
                text = note.second,
                color = Color.White
            )
        }
    }
}

