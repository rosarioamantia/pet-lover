package com.rosario.petlover.data

sealed class UserDataUiAction{
    data class UserNameEntered(val name: String) : UserDataUiAction()
    data class AnimalSelected(val animalValue: String) : UserDataUiAction()
}