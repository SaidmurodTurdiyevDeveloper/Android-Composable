package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposibleapp.ui.theme.MyFirstComposibleAppTheme

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 16/07/2022.
 */

@Composable
fun MySixthComposable() {
    MyFirstComposibleAppTheme {
        /**
        //First step
        val scrollState = rememberScrollState()
        Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {
        for (i in 0..50) {
        Text(
        text = "Item $i", modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        )
        }
        }
         **/
        /**
        //Second step
        LazyColumn {
        items(2000) {
        Text(
        text = "Item $it", modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        )
        }
        }
         **/
        //Third step
        LazyColumn {
            itemsIndexed(listOf("This", "is", "fifth", "composable", "lesson", "app")) { index, text ->
                Text(
                    text = text, modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}