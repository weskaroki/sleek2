package com.wes.sleekfashion.ui.theme.Products

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wes.sleekfashion.R
import com.wes.sleekfashion.navigation.ROUTE_LOGIN
import com.wes.sleekfashion.navigation.ROUTE_REGISTER


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MAINProductScreen(navController: NavController){
    Column (

        modifier = Modifier.fillMaxSize()
            .background(Color.Black)


        ){
        Navbar()
        Spacer(modifier = Modifier.height(10.dp))
        ImageCard(
            painter = painterResource(id = R.drawable.child
            ),
            contentDescription = "mycard",
            title = "Children's Collection"
        )
        Spacer(modifier = Modifier.height(5.dp))
        ImageCard2(
            painter2 = painterResource(id = R.drawable.ladyy
            ),
            contentDescription2 = "mycard2",
            title2 = "Ladies Collection"
        )


    }
}
@Composable
fun ImageCard(painter: Painter, contentDescription: String, title: String) {
    Column() {


        Card(
            modifier = Modifier.fillMaxWidth()
                .wrapContentWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(20.dp)
        ) {
            Box(
                modifier = Modifier.height(200.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(15.dp),
                    contentAlignment = Alignment.BottomStart

                ) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        color = Color.DarkGray,

                    )

                }
            }
        }
    }
}
@Composable
fun ImageCard2(painter2: Painter, contentDescription2: String, title2: String) {
    Column() {


        Card(
            modifier = Modifier.fillMaxWidth()
                .wrapContentWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(20.dp)
        ) {
            Box(
                modifier = Modifier.height(200.dp)
            ) {
                Image(
                    painter = painter2,
                    contentDescription = contentDescription2,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(15.dp),
                    contentAlignment = Alignment.BottomStart

                ) {
                    Text(
                        text = title2,
                        fontSize = 20.sp,
                        color = Color.DarkGray,

                        )

                }
            }
        }
    }
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navbar(){
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text(text = "Sleek Fashion", color = Color.Black) },
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context,"Welcome to the HomeScreen", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "HOME", tint = Color.Gray)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {

            IconButton(onClick = { Toast.makeText(context,"You can now share", Toast.LENGTH_SHORT) .show()}) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "share", tint = Color.Gray)
            }
            IconButton(onClick = { Toast.makeText(context,"This is the menu Icon", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Menu", tint = Color.Gray)
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "PERSON", tint = Color.Gray )
            }
        })
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun  MAINProductScreenPreview(){
    MAINProductScreen(rememberNavController())
}