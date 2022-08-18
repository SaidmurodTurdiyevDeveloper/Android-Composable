package com.example.myfirstcomposibleapp.ui.lessons

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposibleapp.R
import kotlinx.coroutines.delay

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 17/08/2022.
 */
@Composable
fun MySixteenthLesson() {
    var navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navHostController = navHostController)
        }
        composable("main_screen") {
            HomeScreen()
        }
    }

}

@Composable
fun SplashScreen(navHostController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(targetValue = 0.3f, animationSpec = tween(durationMillis = 500, easing = {
            OvershootInterpolator(2f).getInterpolation(it)
        }))
        delay(3000)
        navHostController.navigate("main_screen")
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.android_logo_png),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale = scale.value)
        )
    }
}

@Composable
private fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Main Screen",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}