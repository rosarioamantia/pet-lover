package com.rosario.petlover.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rosario.petlover.data.UserDataUiAction
import com.rosario.petlover.data.UserInputState

class UserInputViewModel : ViewModel(){

    var state by mutableStateOf(UserInputState()) //is both possibile to assign with =
        private set

    fun onEvent(action: UserDataUiAction){
        when(action){
            is UserDataUiAction.UserNameEntered -> updateUserName(action.name)
            is UserDataUiAction.AnimalSelected -> updateAnimalSelected(action.animalValue)
        }
    }

    fun updateUserName(name: String){
        state = state.copy(
            nameEntered = name
        )
        return
    }

    fun updateAnimalSelected(animalValue: String){
        state = state.copy(
            animalSelected = animalValue
        )
        return
    }
}