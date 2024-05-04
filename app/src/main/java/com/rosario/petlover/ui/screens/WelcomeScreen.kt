package com.rosario.petlover.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.rosario.petlover.ui.QuotationCard
import com.rosario.petlover.ui.TextComponent
import com.rosario.petlover.ui.TextWithShadow
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

            TextComponent("Thank you for sharing your data", 24.sp, Color.Black)

            Spacer(modifier = Modifier.size(40.dp))

            val finalText = if(animalSelected == "Cat") "You are a Cat Lover \uD83D\uDC31" else "You are a Dog lover \uD83D\uDC36"

            TextWithShadow(finalText)

            Spacer(modifier = Modifier.size(40.dp))
            
            QuotationCard(quotation = "richiama metodo del view model dopo averlo creato e ottieni la frase corretta in base ad animal selected")
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("Username", "Cat")
}