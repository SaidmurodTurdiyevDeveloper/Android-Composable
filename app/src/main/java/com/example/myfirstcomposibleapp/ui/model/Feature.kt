package com.example.myfirstcomposibleapp.ui.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 25/07/2022.
 */
data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
