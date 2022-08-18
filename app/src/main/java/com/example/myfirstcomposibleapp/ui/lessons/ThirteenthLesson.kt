package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 11/08/2022.
 */
@Composable
fun MyThirteenthLesson() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(Modifier.fillMaxSize()) {
            DropDown(text = "DropDown", isOpen = false) {
                LazyColumn {
                    val list = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11")
                    itemsIndexed(list) { index, item ->
                        Box(
                            contentAlignment = Alignment.Center, modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Text(
                                text = item, modifier = Modifier
                                    .height(50.dp)
                                    .clickable {
                                        scope.launch {
                                            scaffoldState.snackbarHostState.showSnackbar("Text $item\nIndex $index")
                                        }
                                    }, color = Color.Cyan,
                                fontSize = 24.sp
                            )
                        }

                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Blue)
            )
        }
    }
}

@Composable
private fun DropDown(text: String, isOpen: Boolean = false, container: @Composable () -> Unit) {
    var isOpenDropDown by remember {
        mutableStateOf(isOpen)
    }
    var size by remember {
        mutableStateOf(56.dp)
    }
    val alpha = animateFloatAsState(targetValue = if (isOpenDropDown) 1f else 0f, animationSpec = tween(durationMillis = 300))
    val roteteX = animateFloatAsState(targetValue = if (isOpenDropDown) 1f else 0f, animationSpec = tween(durationMillis = 300))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(size)
            .background(Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    size = if (!isOpenDropDown) 200.dp else 56.dp
                    isOpenDropDown = !isOpenDropDown
                }, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = text, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.Cyan)
            Icon(
                imageVector = Icons.Default.ArrowDropDown, contentDescription = "Open or close of drop down",
                tint = Color.Cyan,
                modifier = Modifier
                    .size(32.dp)
                    .scale(1f, if (isOpenDropDown) -1f else 1f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    transformOrigin = TransformOrigin(0.5f, 0f)
                    rotationX = roteteX.value
                }
                .alpha(alpha.value)
        ) {
            container()
        }
    }
}