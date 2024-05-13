package com.wes.myapp.ui.theme.Screens.Profile

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wes.myapp.R

@Composable
fun Profile(navController: NavController){
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .aspectRatio(1.5f),
        colors = CardDefaults
            .cardColors(containerColor = Color.Gray),
        elevation = CardDefaults.cardElevation(10.dp)  ) {
        Box (modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text(
                text = "WELCOME",
                fontSize = 20.sp)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun  ProfilePreview(){
    Profile(navController = rememberNavController())
}


