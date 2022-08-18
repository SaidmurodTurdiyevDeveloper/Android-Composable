package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposibleapp.R
import com.example.myfirstcomposibleapp.ui.theme.MyFirstComposibleAppTheme

@Composable
fun MyThirdLesson() {
    val fontfamily = FontFamily(Font(R.font.lobsten, FontWeight.Thin))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(colors = listOf(Color.Black, Color.DarkGray, Color.Gray)))
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green, fontSize = 50.sp)) {
                    append("J")
                }
                append("etpack ")
                withStyle(style = SpanStyle(color = Color.Green, fontSize = 50.sp)) {
                    append("C")
                }
                append("omposable")
            },
            fontSize = 40.sp,
            fontFamily = fontfamily,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline
        )
    }

}

@Composable
fun MyThirdLessonExample() {
    MyFirstComposibleAppTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(150.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 12.dp, bottom = 12.dp, start = 16.dp, end = 4.dp)
                        .background(Brush.horizontalGradient(colors = listOf(Color.Red, Color.Red, Color.Red, Color.Red, Color.Blue, Color.Green, Color.White)))
                )
                Text(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textDecoration = TextDecoration.Underline,
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(Color.White, fontSize = 70.sp)) {
                            append("C")
                        }
                        append("olgate")
                    },
                    fontSize = 65.sp,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}