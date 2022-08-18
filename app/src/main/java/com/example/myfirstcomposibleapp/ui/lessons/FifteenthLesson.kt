package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfirstcomposibleapp.ui.model.ScreenRoute

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 16/08/2022.
 */
@Composable
fun MyFifteenthLesson() {
    Navigation()
}

@Composable
private fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_screen") {
        composable(route = ScreenRoute.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = ScreenRoute.DetailScreen.route + "/{text}", arguments = listOf(navArgument("text") {
            type = NavType.StringType
            defaultValue = "Salom"
            nullable = true
        })) { entry ->
            DetailScreen(text = entry.arguments?.getString("text"))
        }
    }
}

@Composable
private fun MainScreen(navController: NavHostController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {
        TextField(value = text, onValueChange = {
            text = it
        }, Modifier.fillMaxWidth())
        Button(
            onClick = {
                navController.navigate(ScreenRoute.DetailScreen.withObject(text))
            },
            Modifier
                .align(Alignment.End)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "open detail screen")
        }
    }
}

@Composable
fun DetailScreen(text: String?) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "You write text $text")
    }
}
