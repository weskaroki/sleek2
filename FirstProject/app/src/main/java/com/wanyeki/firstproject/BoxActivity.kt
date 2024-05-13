package com.wanyeki.firstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanyeki.firstproject.ui.theme.FirstProjectTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColorScreen()
                }
            }
        }
    }
}
@Composable
fun ColorScreen(){
   Box (
       modifier = Modifier
           .background(Color.Blue)
           .fillMaxSize()
   ) {
    Box(
        modifier = Modifier
            .background(Color.Red)
            .width(200.dp)
            .height(200.dp)
    ) {
        Box (modifier = Modifier
            .background(Color.Green))   {
            Text(text = "This is a box layout")
        }

    }
   }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColorScreenPreview(){
    ColorScreen()
}
