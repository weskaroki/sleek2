package com.wes.myapp.ui.theme.Screens.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wes.myapp.R

@Composable
fun Gallery(navController: NavController){
    Box (modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.pic) ,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    Box (
        modifier = Modifier.fillMaxWidth(),
                  Alignment.Center  ) {
        Button(onClick = { /*TODO*/ }) {
           Text(text = "To Home screen")
        }
    }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun  GalleryPreview(){
    Gallery(navController = rememberNavController())
}
