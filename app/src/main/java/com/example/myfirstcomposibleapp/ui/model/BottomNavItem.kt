package com.example.myfirstcomposibleapp.ui.model

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 18/08/2022.
 */
data class BottomNavItem(val name: String, val route: String, val icon: ImageVector, val badgeCount: Int = 0)
