package com.example.earth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


val Yellow = Color(0xFFFFFFF20)




@Composable
@Preview(showSystemUi = true)
fun LearningRow() {
    Column (   modifier = Modifier
        .fillMaxSize().background(Yellow)
    ){
/*No need to look at ki mene kesi design de rakhi , kidhar button chla gya kidhar text , just its a random experimental stuff! */
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {    // isse ye samjhlo, ki Column() hota h various elements ko vertically one next to other align karne ke liye
            // Aur similarly Row() ka upyog karte h elements ko Horizontally one after another Align karne ke liye
            Text(text = "I am Master Android Developer!!", fontSize = 34.sp)

            Button(onClick = { /*TODO*/ }) {
                Text(text = "")
            }
            Column {
                Text(text = "ThankYou Sachin")
                Button(onClick = {/*TODO*/ }) {
                    Text(text = "Hey Champ!")
                }

            }
        }
        Column {

            Text(text = "sharmaji")
            Button(onClick = {/*TODO*/ }) {
                Text(text = "In Column")
            }
        }
    }

}

