package com.wes.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wes.jetpackcompose.ui.theme.JetpackcomposeTheme

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val students = listOf(
                        Image(painter = painterResource(id = R.drawable.pexels),
                            contentDescription = "image"
                        ),"Wick","wes","Ivy","chloe",
                        "kevin","Fay","Alice","foden","Haaland","Grace")
                    LazyHome(students:List<>)
                }
            }
        }
    }
}
@Composable
fun LazyHome(students:List<Any>){
    Box (modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.na) , 
            contentDescription = "background image" ,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }
    Column (modifier = Modifier.fillMaxSize()){
        LazyColumn(contentPadding = PaddingValues(20.dp)
        ) {
            items (items=students){
                item->
                ColumnCard(name = item)
            }
        }
    }
}
@Composable
fun ColumnCard(name:Any){
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .aspectRatio(1.5f),
        colors = CardDefaults
            .cardColors(containerColor = Color.Magenta),
              elevation = CardDefaults.cardElevation(10.dp)  ) {
        Box (modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
                contentAlignment = Alignment.Center) {
            Text(
                text = name,
                fontSize = 40.sp)
        }
    }
}

@Preview
@Composable
fun LazyHomePreview(){
//    LazyHome(students:List<string>)
}