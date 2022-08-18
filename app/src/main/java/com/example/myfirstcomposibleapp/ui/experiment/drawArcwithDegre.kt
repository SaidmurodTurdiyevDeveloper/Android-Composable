package com.example.myfirstcomposibleapp.ui.experiment

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 10/08/2022.
 */
@Composable
fun drawMyArc() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier) {
            drawArc(color = Color.Green, startAngle = -215f, sweepAngle = 250f, useCenter = false, style = Stroke(20f, cap = StrokeCap.Round), size = Size(200f, 200f))
        }
    }
}