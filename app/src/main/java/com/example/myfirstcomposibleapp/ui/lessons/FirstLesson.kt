package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposibleapp.ui.theme.MyFirstComposibleAppTheme

@Composable
fun MyFirstLesson() {
    MyFirstComposibleAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(0.9f)
                .background(Color.Cyan)
                .border(5.dp, Color.Green)
                .padding(5.dp)
                .border(5.dp, Color.Magenta)
                .padding(5.dp)
                .border(5.dp, Color.Black, RoundedCornerShape(80.dp))
                .padding(15.dp)
        ) {
            Text(text = "First Lesson!")
        }
    }
}

@Composable
fun MyFirstLessonExample() {
    MyFirstComposibleAppTheme {
        Column(
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom
            ) {
                Text(text = "0", style = TextStyle(color = Color.White, fontSize = 92.sp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.16f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.25f)
                        .background(Color.LightGray),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "AC", style = TextStyle(color = Color.Black, fontStyle = FontStyle(2), fontSize = 32.sp)
                    )
                }
                Spacer(modifier = Modifier.width(2.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.333333f)
                        .background(Color.LightGray),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "+/-", style = TextStyle(color = Color.Black, fontStyle = FontStyle(2), fontSize = 32.sp)
                    )
                }
                Spacer(modifier = Modifier.width(2.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.5f)
                        .background(Color.LightGray),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "%", style = TextStyle(color = Color.Black, fontStyle = FontStyle(2), fontSize = 32.sp)
                    )
                }
                Spacer(modifier = Modifier.width(2.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(Color.Green),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "/", style = TextStyle(color = Color.Black, fontStyle = FontStyle(2), fontSize = 32.sp)
                    )
                }
            }
        }
    }
}