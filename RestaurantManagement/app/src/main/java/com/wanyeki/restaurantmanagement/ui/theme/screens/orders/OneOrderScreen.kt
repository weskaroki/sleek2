package com.wanyeki.restaurantmanagement.ui.theme.screens.orders

import androidx.compose.animation.core.animate
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class OneOrderScreen(
    private val orderViewModel: OrderViewModel,
    private var selectedColor: MutableState<String>,
    private var locked: MutableState<Boolean>
) {

    @Composable
    fun Show() {
        orderViewModel.selectColor(selectedColor.value)

        val selectedOrderItems by orderViewModel.chosenItems
            .collectAsState(initial = emptyList())

        val text = remember { mutableStateOf("") }
        orderViewModel.search(text.value)
        val filteredMenuItems by orderViewModel.menu
            .collectAsState(initial = emptyList())

        var target by remember(selectedColor.value) { mutableStateOf(0f)}
        val opacity = animate(target = target)
        if (target == 0f)
            target = 1f
        LazyColumn(Modifier.drawOpacity(opacity = opacity)) {
            items(selectedOrderItems) { CustomerItem(it) }

            item {
                CustomerNote()
            }

            if (locked.value) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    RoundedSearchBar(text)
                }

                items(filteredMenuItems) { MenuItem(it) }
            }
        }
    }

    @Composable
    private fun CustomerItem(item: Pair<MenuItemDTO, Int>) {
        Surface(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            color = getColorOr(selectedColor.value),
            shape = CircleShape,
        ) {
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = smartSubstring(item.first.name, 25),
                    modifier = Modifier.padding(16.dp, 0.dp),
                    color = MaterialTheme.colors.primary
                )

                Row {
                    val number = item.second
                    if (locked.value) {
                        RoundedIconButton(
                            modifier = Modifier.then(Modifier.preferredSize(24.dp)),
                            asset = Icons.Default.KeyboardArrowDown,
                            onClick = {
                                // if (locked.value && number.value > 0) {
                                if (number > 0) {
                                    orderViewModel.changeNumber(item.first.id, number - 1)
                                }
                            })
                    }
                    Text(
                        modifier = Modifier.padding(8.dp, 0.dp),
                        text = number.toString(),
                        color = MaterialTheme.colors.primary
                    )
                    if (locked.value) {
                        RoundedIconButton(
                            modifier = Modifier.then(Modifier.preferredSize(24.dp)),
                            asset = Icons.Default.KeyboardArrowUp,
                            onClick = {
                                // if (locked.value) {
                                orderViewModel.changeNumber(item.first.id, number + 1)
                                // }
                            })
                    }
                }
            }
        }
    }


    @Composable
    private fun CustomerNote() {
        val selectedOrderNote = orderViewModel.allScreenNotes
            .map { list -> list.firstOrNull {
                it.first == selectedColor.value
            } }
            .map { if(it?.second != "_") it?.second else "" }
            .collectAsState(initial = "") as MutableState

        TextField(
            placeholder = { Text(text = if (selectedOrderNote.value.isNullOrBlank()) "Scrie notiță..."
            else selectedOrderNote.value ?: "Scrie notiță...", color = Color.White) },
            textStyle = TextStyle (color = MaterialTheme.colors.primary),
            // activeColor = MaterialTheme.colors.primary,
            // inactiveColor = MaterialTheme.colors.primaryVariant,
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            backgroundColor = getColorOr(selectedColor.value),
            value = selectedOrderNote.value ?: "",
            onValueChange = {
                if (locked.value) {
                    selectedOrderNote.value = it
                    orderViewModel.changeNote(it)
                }
            })
    }

    @Composable
    private fun MenuItem(it: MenuItemDTO) {
        RoundedButtonRowCard(
            border = BorderStroke(2.dp, MaterialTheme.colors.onPrimary),
            color = getColorOr(selectedColor.value),
            onClick = {
                // if (locked.value) {
                orderViewModel.addMenuItem(it.id)
                // }
            }
        ) {
            Text(text = smartSubstring(it.name, 25))
            Text(text = "${it.price} RON")
        }
    }
}