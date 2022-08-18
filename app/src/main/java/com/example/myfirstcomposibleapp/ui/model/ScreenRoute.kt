package com.example.myfirstcomposibleapp.ui.model

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 17/08/2022.
 */
sealed class ScreenRoute(val route: String) {
    object MainScreen : ScreenRoute("main_screen")
    object DetailScreen : ScreenRoute("detail_screen")

    fun withObject(vararg name: String): String {
        return buildString {
            append(route)
            name.forEach { arg ->
                append("/$arg")
            }
        }
    }
}