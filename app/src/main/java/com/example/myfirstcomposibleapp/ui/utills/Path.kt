package com.example.myfirstcomposibleapp.ui.utills

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 25/07/2022.
 */
fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    quadraticBezierTo(from.x, from.y, abs(from.x + to.x) / 2f, abs(from.y + to.y) / 2f)
}