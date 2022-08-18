package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposibleapp.R
import com.example.myfirstcomposibleapp.ui.theme.MyFirstComposibleAppTheme

@Composable
fun MySecondLesson() {
    val painter = painterResource(id = R.drawable.ice)
    val description = "Ice image"
    val title = "The best ice image"
    MyFirstComposibleAppTheme() {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.5f)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(), shape = RoundedCornerShape(15.dp), elevation = 5.dp
            ) {
                Box(modifier = Modifier.height(200.dp)) {
                    Image(painter = painter, contentDescription = description, contentScale = ContentScale.Crop)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(brush = Brush.verticalGradient(colors = listOf(Color.Transparent, Color.Black), startY = 300f))
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp), contentAlignment = Alignment.BottomStart
                    ) {
                        Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                    }
                }
            }
        }
    }
}

@Composable
fun MySecondComposableExample() {
    MyFirstComposibleAppTheme {
        Row {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ice), contentDescription = "Ice Image")
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(shape = RoundedCornerShape(8.dp), elevation = 4.dp) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(painter = painterResource(id = R.drawable.ice), contentDescription ="big ice image" )
                    }
                }

            }
        }
    }
}