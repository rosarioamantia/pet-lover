package com.rosario.petlover

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rosario.petlover.ui.UserInputViewModel
import com.rosario.petlover.ui.screens.PetLoverNavigationGraph
import com.rosario.petlover.ui.screens.Routes
import com.rosario.petlover.ui.theme.PetLoverTheme
import com.rosario.petlover.ui.screens.UserInputScreen
import com.rosario.petlover.ui.screens.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetLoverTheme {
                PetLoverApp()
            }
        }
    }
}

// entry point for application
@Composable
fun PetLoverApp(){
    PetLoverNavigationGraph()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PetLoverTheme {
        Greeting("Android")
    }
}