package com.rosario.petlover.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosario.petlover.R
import com.rosario.petlover.data.UserDataUiAction
import com.rosario.petlover.ui.AnimalCard
import com.rosario.petlover.ui.ButtonComponent
import com.rosario.petlover.ui.TextComponent
import com.rosario.petlover.ui.TextFieldComponent
import com.rosario.petlover.ui.TopBar
import com.rosario.petlover.ui.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit
){

    val context = LocalContext.current

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

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiAction.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(30.dp))

            TextComponent(
                textValue = "What do you like?",
                textSize = 18.sp)

            Spacer(modifier = Modifier.size(20.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard(
                    R.drawable.pixel_cat,
                    animalSelected = {//callback inside {} with Lambda function
                        userInputViewModel.onEvent(
                            UserDataUiAction.AnimalSelected(it) //update state
                        )
                    },
                    selected = userInputViewModel.state.animalSelected.equals("Cat")) //read state to trigger border card color logic
                AnimalCard(
                    R.drawable.pixel_dog,
                    animalSelected = {//callback inside {} with Lambda function
                        userInputViewModel.onEvent(
                            UserDataUiAction.AnimalSelected(it) //update state
                        )
                    },
                    selected = userInputViewModel.state.animalSelected.equals("Dog")) //read state to trigger border card color logic
            }

            Spacer(modifier = Modifier.weight(1f))

            if(userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailsScreen = { //callback inside {} with Lambda function
                        Toast.makeText(context, "called goToDetailsScreen()", Toast.LENGTH_LONG).show()
                        Toast.makeText(context, "your name is ${userInputViewModel.state.nameEntered}" +
                                " and your animal is a ${userInputViewModel.state.animalSelected}", Toast.LENGTH_LONG).show()
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.state.nameEntered,
                                userInputViewModel.state.animalSelected
                            )
                        )
                    })
            }
        }
    }
}

