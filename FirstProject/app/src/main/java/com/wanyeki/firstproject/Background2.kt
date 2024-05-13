package com.wanyeki.firstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.wanyeki.firstproject.ui.theme.FirstProjectTheme

class Background2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   HomeScreen2()
                }
            }
        }
    }
}

@Composable
fun HomeScreen2(){
    Box (
        modifier = Modifier
            .fillMaxSize()

    ){
        Image(painter = painterResource(id = R.drawable.back),
             contentDescription = "background2" ,
             contentScale = ContentScale.FillBounds,
            modifier =Modifier.matchParentSize())



    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview2(){
    HomeScreen2()
}


