package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposibleapp.ui.theme.MyFirstComposibleAppTheme

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 16/07/2022.
 */

@Composable
fun MyEighthLesson() {
    MyFirstComposibleAppTheme {
        var stateSize by remember {
            mutableStateOf(100.dp)
        }
        val animateSize by animateDpAsState(
            targetValue = stateSize,
//            spring(Spring.DampingRatioLowBouncy),
//            keyframes {
//                durationMillis = 5000
//                stateSize at 0 with LinearEasing
//                stateSize * 1.5f at 1000 with FastOutSlowInEasing
//                stateSize * 2f at 5000
//            },
            tween(durationMillis = 5000, delayMillis = 100, easing = LinearOutSlowInEasing)
        )
        val infiniteTransition = rememberInfiniteTransition()
        val color by infiniteTransition.animateColor(
            initialValue = Color.Red, targetValue = Color.Green, animationSpec = InfiniteRepeatableSpec(
                tween(durationMillis = 3000),
                repeatMode = RepeatMode.Reverse
            )
        )
        Box(
            modifier = Modifier
                .size(animateSize)
                .background(color)
        )
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Button(onClick = {
                stateSize += 20.dp
            }) {
                Text(text = "Animate Slow")
            }
        }
    }
}