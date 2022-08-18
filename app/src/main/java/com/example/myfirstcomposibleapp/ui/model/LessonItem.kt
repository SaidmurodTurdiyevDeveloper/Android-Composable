package com.example.myfirstcomposibleapp.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 11/08/2022.
 */
interface LessonItem

data class SimpleLessonItem(
    var text: String,
    var route: String,
    var color:Color=Color.Magenta
) : LessonItem

data class MultipleLessonItem(var text: String, var examples: List<SimpleLessonItem>) : LessonItem