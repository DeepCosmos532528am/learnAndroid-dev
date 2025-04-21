package com.example.earth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



  fun main() {   // dekho bhai jisme composable ke alaawa aese kotlin code alag se daalte h toh wo preview me toh show hota h , lekin emulator pe show nahi hota h,
      println("Hello World")
  }
@Composable

@Preview(showSystemUi = true)
fun JetpackCompose() {
    Text(text = "Sachin") //  Text(text = "") is a specific composable function provided by Jetpack Compose that is used to display text on the screen / or put text on the screen ,
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) { // Coulmn() is a composable function used to align the items in vertical order (e.g. text, image,Buttons, any elment etc...)


        Text(text = "Sachin")
        Text(text = "Sharma")


        Button(onClick = { /*TODO*/ }) {
            Text(text = "Download")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Upload.....")
        }

    }

}

