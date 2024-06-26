package com.rosario.petlover.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosario.petlover.R
import com.rosario.petlover.Utils

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
        modifier = Modifier.fillMaxWidth(),
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
            modifier = Modifier
                .fillMaxSize()
                .border(
                    shape = RoundedCornerShape(10.dp),
                    width = 2.dp,
                    color = if (selected) Color.Green else Color.Transparent
                )
        ){
            val localFocusManager = LocalFocusManager.current
            Image(
                modifier = Modifier
                    .padding(5.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        val animalName = if (image == R.drawable.pixel_cat) "Cat" else "Dog"
                        animalSelected(animalName) //call it to trigger the function defined inside @Composable
                        localFocusManager.clearFocus()
                    },
                painter = painterResource(id = image),
                contentDescription = "Animal image")
        }
    }
}

@Composable
fun QuotationCard(quotation: String){
    Card(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp, 24.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(20.dp),
                contentDescription = "Double quote image",
                painter = painterResource(id = R.drawable.double_quote))

            TextWithShadow(text = quotation)

            Image(
                modifier = Modifier
                    .size(20.dp)
                    .rotate(180f),
                contentDescription = "Double quote image",
                painter = painterResource(id = R.drawable.double_quote))
        }

    }
}

@Composable
fun ButtonComponent(
    goToDetailsScreen: () -> Unit
){
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToDetailsScreen()
        }
    ) {
        TextComponent(
            textValue = "Go to Details Screen",
            textSize = 18.sp,
            color = Color.White
            )
    }
}

@Composable
fun TextWithShadow(text: String){
    val shadowOffset = Offset(x = 1f, y = 2f)
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(Utils.generateRandomColor(), offset = shadowOffset, 10f)
        ),
    )
}

@Preview(showBackground = false)
@Composable
fun ButtonComponentPreview(){
    //ButtonComponent({""})
}

@Preview(showBackground = false)
@Composable
fun AnimalCardPreview(){
    AnimalCard(
        image = R.drawable.pixel_dog,
        selected = false,
        animalSelected = { "Dog" })
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

@Preview(showBackground = true)
@Composable
fun QuotationCardPreview(){
    QuotationCard(quotation = "Ciaociao")
}