package com.rosario.petlover.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rosario.petlover.ui.TopBar
import com.rosario.petlover.ui.UserInputViewModel

@Composable
fun WelcomeScreen(navController: NavHostController, userInputViewModel: UserInputViewModel){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
            navController.navigate(Routes.USER_INPUT_SCREEN)
        }
    ) {
        TopBar("Welcome + aggiungi nome")
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    //WelcomeScreen(rememberNavController())
}