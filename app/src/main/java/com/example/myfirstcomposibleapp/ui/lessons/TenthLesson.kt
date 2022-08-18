package com.example.myfirstcomposibleapp.ui.lessons

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposibleapp.R
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.roundToInt

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 23/07/2022.
 */
@Composable
fun MyTenthLesson() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(4.dp, Color.Green, shape = RoundedCornerShape(8.dp))
                .padding(30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var volume by remember {
                mutableStateOf(0f)
            }
            val maxVolume = 20
            MusicKnob(Modifier.size(100.dp)) {
                volume = it
            }
            Spacer(modifier = Modifier.width(20.dp))
            ValueBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                count = (maxVolume * volume).roundToInt(),
                maxCount = maxVolume
            )
        }
    }
}

@Composable
fun ValueBox(modifier: Modifier = Modifier, count: Int = 0, maxCount: Int = 10) {
    BoxWithConstraints(contentAlignment = Alignment.Center, modifier = modifier) {
        val barWidth by remember {
            mutableStateOf(2*constraints.maxWidth / (3f * maxCount-1f))
        }
        Canvas(modifier = modifier) {
            for (i in 0 until count) {
                drawRoundRect(
                    color = Color.Green,
                    topLeft = Offset(barWidth * (i * 3f + 1f) / 2f, 0f),
                    size = Size(barWidth, constraints.maxHeight.toFloat()),
                    cornerRadius = CornerRadius(2f)
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MusicKnob(
    modifier: Modifier = Modifier,
    limitingAngel: Float = 25f,
    onValueChange: (Float) -> Unit
) {
    var rotation by remember {
        mutableStateOf(limitingAngel)
    }
    var touchX by remember {
        mutableStateOf(0f)
    }
    var touchY by remember {
        mutableStateOf(0f)
    }
    var centerX by remember {
        mutableStateOf(0f)
    }
    var centerY by remember {
        mutableStateOf(0f)
    }
    Image(
        painter = painterResource(id = R.drawable.knob),
        contentDescription = "Knob",
        modifier = modifier
            .fillMaxSize()
            .onGloballyPositioned {
                val boundsWindow = it.boundsInWindow()
                centerX = boundsWindow.size.width / 2f
                centerY = boundsWindow.size.height / 2f
            }
            .pointerInteropFilter { motionEvent ->
                touchX = motionEvent.x
                touchY = motionEvent.y
                val angel = -atan2(centerX - touchX, centerY - touchY) * (180 / PI).toFloat()
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN,
                    MotionEvent.ACTION_MOVE -> {
                        //there our rotate is not working from -limiting angel until limiting angel  because Music Knock is finished here
                        if (angel !in -limitingAngel..limitingAngel) {
                            val fixedAngel = if (angel in -180f..-limitingAngel) angel + 360f else angel
                            rotation = fixedAngel
                            val percent = (fixedAngel - limitingAngel) / (360 - 2 * limitingAngel)
                            onValueChange(percent)
                            true
                        } else false
                    }
                    else -> false
                }
            }
            .rotate(rotation)
    )
}

@Composable
fun MyTenthLessonExample() {

}

