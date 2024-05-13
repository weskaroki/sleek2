package com.wanyeki.firstproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanyeki.firstproject.ui.theme.FirstProjectTheme

class LoginActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column {
                        LoginScreen()
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = { val intent =Intent(this@LoginActivity2,MainActivity::class.java)
                                        startActivity(intent)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)){
                            Text(text = "Login Here")
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)){
                            Text(text = "Register here")

                        }
                    }
                }
            }
        }
    }
}
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp)),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login here",
            fontSize = 25.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
           fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .background(Color.Green)
                .padding(20.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .height(40.dp)
                .fillMaxWidth()
        )
        ImageComponent()
        Spacer(modifier = Modifier.height(20.dp))
        Username()
        Spacer(modifier = Modifier.height(20.dp))
        Email()
        Spacer(modifier = Modifier.height(20.dp))
        Password()


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}
@Composable
fun Username(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier =Modifier.fillMaxWidth(),
        value = text, onValueChange ={
                newText -> text = newText
        },
        label = {Text(text = "Enter your Username")},
        placeholder = {
            Text(text = "Please Enter your Username")
        } )
}
@Composable
fun Email(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier =Modifier.fillMaxWidth(),
        value = text, onValueChange ={
                newText -> text = newText
        },
        label = {Text(text = "Enter your Email")},
        placeholder = {
            Text(text = "Please Enter your Email")
        } )
}

@Composable
fun Password(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier =Modifier.fillMaxWidth(),
        value = text, onValueChange ={
                newText -> text = newText
        },
        label = {Text(text = "Enter your Password")},
        placeholder = {
            Text(text = "Please Enter your Password")
        } )
}
@Composable
fun ImageComponent(){
    Image( modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .height(80.dp),

        painter = painterResource(id = R.drawable.logo),
        contentDescription = "my logo")
}

