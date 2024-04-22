package com.rosario.petlover.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rosario.petlover.ui.TextComponent
import com.rosario.petlover.ui.TopBar

@Composable
fun UserInputScreen(navController: NavHostController){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ){
            TopBar("Hi there \uD83D\uDE04")

            TextComponent("Let's learn about you!", 24.sp, Color.Black)

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This page will prepare a details page based on input provided by you",
                textSize = 18.sp)

            Spacer(modifier = Modifier.size(60.dp))

           // TextField(value = "ciao", onValueChange = )
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(rememberNavController())
}