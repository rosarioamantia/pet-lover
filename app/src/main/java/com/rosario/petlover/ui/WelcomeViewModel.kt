package com.rosario.petlover.ui

import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel(){

    fun generateRandomQuotation(selectedAnimal: String?): String{
        return if(selectedAnimal == "Dog"){
            getDogQuotation().random()
        }else{
            getCatQuotation().random()
        }
    }

    private fun getDogQuotation(): List<String> {
        return listOf(
            "Outside of a dog, a book is a man’s best friend. Inside of a dog it’s too dark to read.",
            "No matter how you’re feeling, a little dog gonna love you.",
            "A dog is the only thing on earth that loves you more than you love yourself."
        )
    }

    private fun getCatQuotation(): List<String>{
        return listOf(
            "In ancient times cats were worshipped as gods; they have not forgotten this.",
            "Cats are inquisitive, but hate to admit it.",
            "Many people prefer cats to other people, and many cats prefer people to other cats."
        )
    }

}