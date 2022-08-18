package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myfirstcomposibleapp.ui.theme.MyFirstComposibleAppTheme
import kotlin.random.Random

@Composable
fun MyFourthLesson() {
    val color = remember {
        mutableStateOf(Color.Yellow)
    }
    MyFirstComposibleAppTheme {
        Column() {
            Box(modifier = Modifier
                .background(Color.Red)
                .weight(1f)
                .fillMaxSize()
                .clickable {
                    color.value = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
                })
            Box(modifier = Modifier
                .background(color.value)
                .weight(1f)
                .fillMaxSize())
        }
    }
}