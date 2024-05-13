package com.wanyeki.safarimor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanyeki.safarimor.ui.theme.SafarimorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafarimorTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)) {
        Text(text = "Wanyeki's App",
                     color = Color.Black,
                     fontSize = 28.sp,
                     fontFamily = FontFamily.Cursive
            )
        Image(painter = painterResource(id =R.drawable.tems),
            contentDescription ="her",
            )
        Spacer(modifier = Modifier.height(40.dp ))
        Image(painter = painterResource(id =R.drawable.tem),
            contentDescription ="also her",
            )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Welcome to Android App")
    }

}

@Preview
@Composable
private fun Homepreview() {
    Home()
}


