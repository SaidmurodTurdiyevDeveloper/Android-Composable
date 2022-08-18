package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 16/07/2022.
 */

@Composable
fun MySeventhLesson() {
    var constants = ConstraintSet {
        val greenBox = createRefFor(id = "greenBox")
        val redBox = createRefFor(id = "redBox")
        val guideline=createGuidelineFromTop(0.5f)
        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(guideline)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
//        createHorizontalChain(greenBox,redBox)
//        createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Packed)
    }
    ConstraintLayout(constants, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.background(Color.Green).layoutId("greenBox"))
        Box(modifier = Modifier.background(Color.Red).layoutId("redBox"))
    }
}