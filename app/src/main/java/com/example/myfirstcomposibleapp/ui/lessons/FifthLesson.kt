package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposibleapp.R
import com.example.myfirstcomposibleapp.ui.theme.MyFirstComposibleAppTheme
import kotlinx.coroutines.launch

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 16/07/2022.
 */
@Composable
fun MyFifthLesson() {
    val scaffoldState = rememberScaffoldState()
    var textState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    MyFirstComposibleAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
            ) {
                TextField(value = textState, label = {
                    Text(text = "Enter your name")
                }, onValueChange = {
                    textState = it
                }, modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Hello $textState")
                    }
                }) {
                    Text(text = "Press it")
                }
            }
        }
    }
}

@Composable
fun MyFifthLessonExample() {
    MyFirstComposibleAppTheme {
        val painter = painterResource(id = R.drawable.person)
        val scaffoldState = rememberScaffoldState()
        var loginState by remember {
            mutableStateOf("")
        }
        var passwordState by remember {
            mutableStateOf("")
        }
        val scope = rememberCoroutineScope()
        Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    shape = RoundedCornerShape(50.dp), elevation = 5.dp
                ) {
                    Image(painter = painter, contentDescription = "Person image")
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextField(value = loginState, onValueChange = {
                    loginState = it
                }, label = {
                    Text(text = "User name")
                }, singleLine = true)
                Spacer(modifier = Modifier.height(16.dp))
                TextField(value = passwordState, onValueChange = {
                    passwordState = it
                }, label = {
                    Text(text = "Password")
                }, singleLine = true)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("User name $loginState \nPassword $passwordState")
                    }
                }) {
                    Text(text = "press it")
                }
            }
        }
    }
}