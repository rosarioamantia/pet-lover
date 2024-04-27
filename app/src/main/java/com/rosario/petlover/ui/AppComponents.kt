package com.rosario.petlover.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosario.petlover.R

@Composable
fun TopBar(text: String){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){

        Text(
            text = text,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )

        //to subdivide and put spacing
        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.android_symbol_green),
            contentDescription = "Native Mobile Bits")
    }
}

@Composable
fun TextComponent(textValue: String,
                  textSize: TextUnit,
                  color: Color = Color.Black){
    Text(
        text = textValue,
        fontSize = textSize,
        color = color,
    )
}

@Composable
fun TextFieldComponent(
    onTextChanged: (name: String) -> Unit //higher-order-functions (onTextChanged) can accept lambda as parameter
){
    var currentValue by remember{
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        label = { Text(text = "Name", color = Color.Black)},
        value = currentValue,
        onValueChange = {
            currentValue = it //local value
            onTextChanged(it) //effective call - //call it to trigger the function defined inside @Composable
        },
        placeholder = {
            Text(text = "Enter your name")
        },
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        }
    )
}

@Composable
fun AnimalCard(
    image: Int,
    selected: Boolean,
    animalSelected: (animalName: String) -> Unit){ //higher-order-functions (animalSelected) can accept lambda as parameter
    Card (
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Box(
            modifier = Modifier.fillMaxSize()
                .border(
                    shape = RoundedCornerShape(10.dp),
                    width = 2.dp,
                    color = if(selected) Color.Green else Color.Transparent
                )
        ){
            Image(
                modifier = Modifier
                    .padding(5.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable{
                        val animalName = if(image == R.drawable.pixel_cat) "Cat" else "Dog"
                        animalSelected(animalName) //call it to trigger the function defined inside @Composable
                    },
                painter = painterResource(id = image),
                contentDescription = "Animal image")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar("Test test")
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent(
        textValue = "This page will prepare a details page based on input provided by you",
        textSize = 18.sp)
}