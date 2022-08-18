package com.example.myfirstcomposibleapp.ui.experiment

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposibleapp.ui.utills.standardQuadFromTo

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 09/08/2022.
 */
@Composable
fun standartQuadraticReck() {
    BoxWithConstraints() {

        val width = constraints.maxWidth
        val height = constraints.maxHeight
        val lightpoint1 = Offset(0f, height * 0.35f)
        val lightpoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightpoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightpoint4 = Offset(width * 0.65f, height.toFloat())
        val lightpoint5 = Offset(width * 1.4f, -height.toFloat())
        val lightColoredPath = Path().apply {
            moveTo(lightpoint1.x, lightpoint1.y)
            standardQuadFromTo(lightpoint1, lightpoint2)
            standardQuadFromTo(lightpoint2, lightpoint3)
            standardQuadFromTo(lightpoint3, lightpoint4)
            standardQuadFromTo(lightpoint4, lightpoint5)
            lineTo(width.toFloat(), height.toFloat())
            lineTo(0f, height.toFloat())
            close()
        }
        Canvas(
            modifier = Modifier
                .height(height.dp)
                .width(width.dp)
                .background(Color.Red)
        ) {
            drawPath(lightColoredPath, Color.Green)
        }
    }
}
