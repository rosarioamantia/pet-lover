package com.rosario.petlover.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rosario.petlover.ui.TopBar
import com.rosario.petlover.ui.UserInputViewModel

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Welcome ${username}")
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    //WelcomeScreen(rememberNavController())
}