package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposibleapp.ui.model.BottomNavItem

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 17/08/2022.
 */
@Composable
fun MySeventeenthLesson() {
    val navHostController = rememberNavController()
    Scaffold(bottomBar = {

        BottomBudgetMenu(list = listOf(
            BottomNavItem("Home", "home_screen", Icons.Default.Home),
            BottomNavItem("Message", "message_screen", Icons.Default.Notifications, 17),
            BottomNavItem("Setting", "setting_screen", Icons.Default.Settings, 200)
        ),
            navHostController = navHostController, onItemClick = {
                navHostController.navigate(it.route)
            })
    }) {
        Navigation(navHostController = navHostController)
    }
}

@Composable
private fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home_screen") {
        composable(route = "home_screen") {
            HomeScreen()
        }
        composable(route = "message_screen") {
            MessageScreen()
        }
        composable(route = "setting_screen") {
            SettingScreen()
        }
    }
}

@Composable
fun BottomBudgetMenu(list: List<BottomNavItem>, navHostController: NavController, modifier: Modifier = Modifier, onItemClick: (BottomNavItem) -> Unit) {
    val backStackEntry = navHostController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier, backgroundColor = Color.DarkGray, elevation = 5.dp) {
        list.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected,
                onClick = {
                    onItemClick(it)
                },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (it.badgeCount > 0) {
                            BadgedBox(badge = {
                                Text(
                                    text = it.badgeCount.toString(),
                                    modifier
                                        .background(Color.Red, shape = RoundedCornerShape(8.dp))
                                        .padding(horizontal = 4.dp)
                                )
                            }) {
                                Column(horizontalAlignment = CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                    Icon(imageVector = it.icon, contentDescription = it.name)
                                    Text(text = it.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                                }
                            }
                        } else {
                            Icon(imageVector = it.icon, contentDescription = it.name)
                        }

                    }
                })
        }
    }
}

@Composable
private fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Home Screen",
            fontWeight = FontWeight.Bold, color = Color.Black,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp
        )
    }
}

@Composable
private fun MessageScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Message Screen",
            fontWeight = FontWeight.Bold, color = Color.Black,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp
        )
    }
}

@Composable
fun SettingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Setting Screen",
            fontWeight = FontWeight.Bold, color = Color.Black,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp
        )
    }
}
