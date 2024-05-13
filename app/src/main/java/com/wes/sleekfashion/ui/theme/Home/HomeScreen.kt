package com.wes.sleekfashion.ui.theme.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wes.sleekfashion.R
import com.wes.sleekfashion.navigation.ROUTE_LOGIN
import com.wes.sleekfashion.navigation.ROUTE_REGISTER

@Composable
 fun HomeScreen(navController: NavController){
     Column (
         modifier = Modifier
             .fillMaxSize()
             .background(Color.DarkGray),

     ){
         Box (modifier = Modifier.fillMaxHeight(0.78f)) {
             Image(
                 painter = painterResource(id = R.drawable.pic),
                 contentDescription = "home",
                 contentScale = ContentScale.FillBounds,

             )}
         Text(text = "Discover your Style With" ,
                 color = Color.White,
                 fontSize = 30.sp,
                 textAlign = TextAlign.Center)
             Text(text = "Sleek Fashion",
                 color = Color.Yellow,
                 fontSize = 30.sp)

             Spacer(modifier = Modifier.height(5.dp))
             Button(onClick = {navController.navigate(ROUTE_LOGIN) }, modifier = Modifier.fillMaxWidth()
             ){
                 Text(text = "Get Started")
             }




         }


     }
     

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}