package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 10/08/2022.
 */
@Composable
fun MyTwelfthLesson() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray), contentAlignment = Alignment.Center
    ) {
        Timer(
            totalTime = 30 * 1000, modifier = Modifier
                .height(350.dp)
                .width(350.dp)
        )
    }
}

@Composable
private fun Timer(
    totalTime: Long,
    modifier: Modifier = Modifier,
    initValue: Float = 1f,
    textColor: Color = Color.White,
    activeColor: Color = Color.Green,
    inActiveColor: Color = Color.LightGray,
    strokeWidth: Dp = 15.dp
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var value by remember {
        mutableStateOf(initValue)
    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimeRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimeRunning) {
        if (currentTime > 0 && isTimeRunning) {
            delay(100)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        } else if (currentTime == 0L && isTimeRunning) {
            currentTime = -1
        }
    }
    Box(modifier = modifier.onSizeChanged {
        size = it
    }, contentAlignment = Alignment.Center) {
        Canvas(modifier = modifier) {
            drawArc(
                color = inActiveColor,
                startAngle = -215f,
                sweepAngle = 250f,
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = activeColor,
                startAngle = -215f,
                sweepAngle = 250f * value,
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            val center = Offset(size.width / 2f, size.height / 2f)
            val beta = (250f * value + 145f) * (PI / 180f).toFloat()
            val x = cos(beta) * size.width / 2f
            val y = sin(beta) * size.height / 2f
            drawPoints(
                points = listOf(Offset(center.x + x, center.y + y)),
                pointMode = PointMode.Points,
                color = activeColor,
                strokeWidth = (strokeWidth * 3).toPx(),
                cap = StrokeCap.Round
            )
        }
        Text(text = (currentTime / 1000L).toString(), fontSize = 44.sp, fontWeight = FontWeight.Bold, color = textColor)
        Button(
            onClick = {
                if (currentTime <= 0L) {
                    currentTime = totalTime
                    isTimeRunning = true
                } else {
                    isTimeRunning = !isTimeRunning
                }
            }, modifier = Modifier.align(Alignment.BottomCenter), colors = ButtonDefaults.buttonColors(
                backgroundColor = if (isTimeRunning || currentTime <= 0L) {
                    Color.Red
                } else {
                    Color.Green
                }
            )
        ) {
            Text(
                text = if (isTimeRunning && currentTime >= 0L) "Stop" else if (!isTimeRunning && currentTime >= 0L) "Start" else "Restart"
            )
        }
    }
}