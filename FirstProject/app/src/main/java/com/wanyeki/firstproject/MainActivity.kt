package com.wanyeki.firstproject

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanyeki.firstproject.ui.theme.FirstProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .height(400.dp)
                        .padding(5.dp),

                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {

                        HelloWorld("wes")
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                val intent = Intent(this@MainActivity,LoginActivity2::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Magenta)
                        ) {
                            Text(text = "Login Here")
                        }

                        
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Magenta)){
                            Text(text = "Register Here")
                        }
                        Button(
                            onClick = { val intent = Intent(this@MainActivity,Background2::class.java)
                                        startActivity(intent)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Magenta)){
                            Text(text = "Background Image")
                        }

                    }



                }
            }
        }
    }
}
@Composable
fun HelloWorld(name:String){
    Column (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp)),
            verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hey  $name !  Welcome   Back",
            fontSize = 25.sp,
            color = Color.Cyan,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Green)
                .padding(20.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .height(40.dp)
                .fillMaxWidth()

//        Text(text = "I am a software Developer/Android Developer",
//            fontSize = 23.sp,
//            color = Color.Blue,
//            fontFamily = FontFamily.SansSerif,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.background(Color.Green)
//                .padding(20.dp))
//
//        Text(text = "I am experienced in this field Of web and app development",
//            fontSize = 23.sp,
//            color = Color.Yellow,
//            fontFamily = FontFamily.SansSerif,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.background(Color.Green)
//                .padding(20.dp))
//
//
//
//
//
//
//
        )
        ImageComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldEmailComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldLocationComponent()
        Spacer(modifier = Modifier.height(20.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(20.dp))

            
    }

}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HelloWorldPreview(){
    HelloWorld("Andrew")
}
@Composable
fun TextFieldComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier =Modifier.fillMaxWidth(),
        value = text, onValueChange ={
        newText -> text = newText
    },
        label = {Text(text = "Enter your name")},
       placeholder = {
           Text(text = "Please Enter your Name")
       } )
}
@Composable
fun TextFieldEmailComponent(){
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
fun TextFieldLocationComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier =Modifier.fillMaxWidth(),
        value = text, onValueChange ={
                newText -> text = newText
        },
        label = {Text(text = "Enter your Location")},
        placeholder = {
            Text(text = "Please Enter your Location")
        } )
}
@Composable
fun PasswordTextField(){
    var password by rememberSaveable { mutableStateOf("")
    }
    var passwordVisibility by remember { mutableStateOf(false)
    }
    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id =R.drawable.design_ic_visibility_off)

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value =password ,
        onValueChange = {
            password =it
        },
        placeholder = { Text(text = "Password")},
        label = { Text(text = "Password")},
        trailingIcon = {
            IconButton(onClick ={
                passwordVisibility=!passwordVisibility

            }) {
                Icon(painter =icon ,
                    contentDescription ="Visibility Icon" )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation()

    )
}


