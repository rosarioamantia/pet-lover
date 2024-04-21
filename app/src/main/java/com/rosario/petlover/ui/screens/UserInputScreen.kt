package com.rosario.petlover.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
            modifier = Modifier.fillMaxSize()
                .padding(18.dp)
        ){
            TopBar("Hi there \uD83D\uDE04")

            TextComponent("Let's learn about you!", 24.sp, Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            TextComponent("Test test", 12.sp)
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(rememberNavController())
}