package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposibleapp.R
import com.example.myfirstcomposibleapp.ui.model.LessonItem
import com.example.myfirstcomposibleapp.ui.model.MultipleLessonItem
import com.example.myfirstcomposibleapp.ui.model.SimpleLessonItem
import com.example.myfirstcomposibleapp.ui.theme.MyFirstComposibleAppTheme
import kotlin.random.Random

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 11/08/2022.
 */
@Composable
fun AllLessonNavController() {
    val navController = rememberNavController()
    val list = ArrayList<LessonItem>()
    list.add(MultipleLessonItem("First lesson", listOf(SimpleLessonItem("Lesson", "first_lesson",Color.Cyan), SimpleLessonItem("Example", "first_lesson_example"))))
    list.add(MultipleLessonItem("Second lesson", listOf(SimpleLessonItem("Lesson", "second_lesson",Color.Unspecified), SimpleLessonItem("Example", "second_lesson_example"))))
    list.add(MultipleLessonItem("Third lesson", listOf(SimpleLessonItem("Lesson", "third_lesson",Color.Yellow), SimpleLessonItem("Example", "third_lesson_example"))))
    list.add(SimpleLessonItem("Fourth Lesson", "fourth_lesson",Color.Magenta))
    list.add(MultipleLessonItem("Fifth lesson", listOf(SimpleLessonItem("Lesson", "fifth_lesson",Color.Red), SimpleLessonItem("Example", "fifth_lesson_example"))))
    list.add(SimpleLessonItem("Sixth Lesson", "sixth_lesson",Color.Green))
    list.add(SimpleLessonItem("Seventh Lesson", "seventh_lesson",Color.Blue))
    list.add(SimpleLessonItem("Eighth Lesson", "eighth_lesson",Color(0x77BB00FF)))
    list.add(SimpleLessonItem("Ninth Lesson", "ninth_lesson",Color.LightGray))
    list.add(MultipleLessonItem("Tenth lesson", listOf(SimpleLessonItem("Lesson", "tenth_lesson",Color(0x22AA00CC)), SimpleLessonItem("Example", "tenth_lesson_example"))))
    list.add(SimpleLessonItem("eleventh Lesson", "eleventh_lesson",Color(0xBB998800)))
    list.add(SimpleLessonItem("Twelfth Lesson", "twelfth_lesson",Color(0xBB53A467)))
    list.add(SimpleLessonItem("Thirteenth Lesson", "thirteenth_lesson",Color(0xBB53A494)))
    list.add(SimpleLessonItem("Fourteenth Lesson", "fourteenth_lesson",Color(0xBB8E53A4)))
    list.add(SimpleLessonItem("Fifteenth Lesson", "fifteenth_lesson",Color(0xBB8CA453)))
    list.add(SimpleLessonItem("Sixteenth Lesson", "sixteenth_lesson",Color(0xBBA46A53)))
    list.add(SimpleLessonItem("Seventeenth Lesson", "seventeenth_lesson",Color(0xBB6553A4)))
    NavHost(navController = navController, startDestination = "main_screen") {
        composable(route = "main_screen") {
            AllMyLessons(list = list, navController = navController)
        }
        composable(route = "first_lesson") {
            MyFirstLesson()
        }
        composable(route = "first_lesson_example") {
            MyFirstLessonExample()
        }
        composable(route = "second_lesson") {
            MySecondLesson()
        }
        composable(route = "second_lesson_example") {
            MySecondComposableExample()
        }
        composable(route = "third_lesson") {
            MyThirdLesson()
        }
        composable(route = "third_lesson_example") {
            MyThirdLessonExample()
        }
        composable(route = "fourth_lesson") {
            MyFourthLesson()
        }
        composable(route = "fifth_lesson") {
            MyFifthLesson()
        }
        composable(route = "fifth_lesson_example") {
            MyFifthLessonExample()
        }
        composable(route = "sixth_lesson") {
            MySixthComposable()
        }
        composable(route = "seventh_lesson") {
            MySeventhLesson()
        }
        composable(route = "eighth_lesson") {
            MyEighthLesson()
        }
        composable(route = "ninth_lesson") {
            MyNinthLesson()
        }
        composable(route = "tenth_lesson") {
            MyTenthLesson()
        }
        composable(route = "tenth_lesson_example") {
            MyTenthLessonExample()
        }
        composable(route = "eleventh_lesson") {
            MyEleventhLesson()
        }
        composable(route = "twelfth_lesson") {
            MyTwelfthLesson()
        }
        composable(route = "thirteenth_lesson") {
            MyThirteenthLesson()
        }
        composable(route = "fourteenth_lesson") {
            MyFourteenthLesson()
        }
        composable(route = "fifteenth_lesson") {
            MyFifteenthLesson()
        }
        composable(route = "sixteenth_lesson") {
            MySixteenthLesson()
        }
        composable(route = "seventeenth_lesson") {
            MySeventeenthLesson()
        }
    }
}

@Composable
private fun AllMyLessons(list: List<LessonItem>, navController: NavHostController) {
    MyFirstComposibleAppTheme {
        LazyColumn {
            itemsIndexed(list) { index, item ->
                if (item is SimpleLessonItem)
                    SimpleItem(item = item, navController)
                else if (item is MultipleLessonItem)
                    MultipleItem(multiItem = item, navController)
                else
                    Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun SimpleItem(
    item: SimpleLessonItem,
    navController: NavHostController
) {
    val color by remember {
        mutableStateOf(item.color)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(item.route)
            }
            .background(color)
            .padding(horizontal = 32.dp)
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item.text, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Icon(painter = painterResource(id = R.drawable.ic_navigate_next), contentDescription = "Next", tint = Color.Black)
    }
}

@Composable
private fun MultipleItem(multiItem: MultipleLessonItem, navController: NavHostController) {
    var isOpen by remember {
        mutableStateOf(false)
    }
    val color by remember {
        mutableStateOf(if (multiItem.examples.isNotEmpty()) multiItem.examples.first().color else Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f))
    }

    val height = animateDpAsState(targetValue = if (isOpen) 150.dp else 64.dp, animationSpec = tween(durationMillis = 400))
    val alpha = animateFloatAsState(targetValue = if (isOpen) 1f else 0f, animationSpec = tween(durationMillis = 400))
    val roteteX = animateFloatAsState(targetValue = if (isOpen) 1f else 0f, animationSpec = tween(durationMillis = 400))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color)
            .height(height.value)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    isOpen = !isOpen
                }
                .padding(horizontal = 32.dp)
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = multiItem.text, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Next", tint = Color.Black,
                modifier = Modifier.scale(1f, if (isOpen) -1f else 1f)
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                itemsIndexed(multiItem.examples) { index, item ->
                    Text(text = item.text, fontSize = 18.sp, modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(item.route)
                        })
                }
            }
        }
    }
}