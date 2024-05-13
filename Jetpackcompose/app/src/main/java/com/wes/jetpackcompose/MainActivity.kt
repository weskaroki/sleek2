package com.wes.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wes.jetpackcompose.ui.theme.JetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fraction = 0.5f)
                            .padding(20.dp)
                    ) {
                        Column {
                            ImageCard(
                                painter = painterResource(id = R.drawable.pexels),
                                contentDescription = "mycard",
                                title = "Welcome For An Exciting nature Drive"
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            ImageCard2(
                                painter2 = painterResource(id = R.drawable.na),
                                contentDescription2 = "mycard2",
                                title2 = "Refresh Yourself Into The Wild Unknown"
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(onClick = {
                                val intent = Intent(this@MainActivity, ScrollActivity::class.java)
                                startActivity(intent)
                            }) {
                                Text(text = "SCROLLABLE")
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(onClick = {
                                val intent = Intent(this@MainActivity, TopAppActivity::class.java)
                                startActivity(intent)
                            }) {
                                Text(text = "Topbar")
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(onClick = {
                                val intent = Intent(this@MainActivity, LazyColumnActivity::class.java)
                                startActivity(intent)
                            }) {
                                Text(text = "LazyColumn")
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ImageCard(painter: Painter, contentDescription: String, title: String) {
        Column() {


            Card(
                modifier = Modifier.wrapContentWidth(),
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
                            color = Color.DarkGray
                        )

                    }
                }
            }
        }
    }

    @Composable
    fun ImageCard2(painter2: Painter, contentDescription2: String, title2: String) {
        Card(
            modifier = Modifier.wrapContentWidth(),
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
                        color = Color.DarkGray
                    )

                }
            }
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun ImageCardPreview() {
        ImageCard(
            painter = painterResource(id = R.drawable.pexels),
            contentDescription = "mycard",
            title = "Welcome For  An Exciting Nature Drive"
        )
    }
}