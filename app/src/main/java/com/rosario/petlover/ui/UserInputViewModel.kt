package com.rosario.petlover.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rosario.petlover.data.UserDataUiAction
import com.rosario.petlover.data.UserInputState

class UserInputViewModel : ViewModel(){
    companion object{
        const val TAG = "UserInputViewModel"
    }

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
        Log.d(TAG, "onEvent:UserNameEntered -> ")
        Log.d(TAG, "${state.nameEntered}")
        return
    }

    fun updateAnimalSelected(animalValue: String){
        state = state.copy(
            animalSelected = animalValue
        )
        Log.d(TAG, "onEvent:AnimalSelected -> ")
        Log.d(TAG, "${state.animalSelected}")
        return
    }

    fun isValidState(): Boolean{
        return (!state.nameEntered.isNullOrEmpty()
                && !state.animalSelected.isNullOrEmpty())
    }
}