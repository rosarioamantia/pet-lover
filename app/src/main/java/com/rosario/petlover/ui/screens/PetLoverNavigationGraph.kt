package com.rosario.petlover.ui.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rosario.petlover.ui.UserInputViewModel

@Composable
fun PetLoverNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()){
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {

        composable(Routes.USER_INPUT_SCREEN){
            UserInputScreen(userInputViewModel, showWelcomeScreen = {
                println("Coming inside show welcome screen")
                println(it.first)
                println(it.second)
                navController.navigate(Routes.WELCOME_SCREEN + "/${it.first}/${it.second}")  // must match with below
            })
        }

        composable("${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.ANIMAL_SELECTED}}", // must match with above
            arguments = listOf(
                navArgument(name = Routes.USER_NAME){ type = NavType.StringType},
                navArgument(name = Routes.ANIMAL_SELECTED){ type = NavType.StringType}
            )){

            val username = it?.arguments?.getString(Routes.USER_NAME)
            val animalSelected = it?.arguments?.getString(Routes.ANIMAL_SELECTED)
            Toast.makeText(context, "Username inserted: ${username}", Toast.LENGTH_LONG).show()
            Toast.makeText(context, "Animal selected: ${animalSelected}", Toast.LENGTH_LONG).show()
            WelcomeScreen(username, animalSelected)
        }
    }
}