package com.example.aboveearth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                Scaffold(modifier = Modifier.fillMaxSize()) { sachin ->
                    Column(
                        modifier = Modifier
                            .padding(sachin)
                            .background( Color.Yellow) // till this line the column scope is very less at left-top of screen , so .fillMaxSize() is used later to extend teh scope to full screeen
                            .background(color = MaterialTheme.colorScheme.background)// add this instead .background( Color.Yellow) to make the column color changeable with theme
                            .fillMaxSize() // fill maxi size is given to extend teh scope of column to full screen !
                        , // Yellow portion in emulator is the by default scope of the column

                        // horizontalAlignment = AbsoluteAlignment.Right // used to align element to he right of the screen , left can also be sued like wise
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null,

                            )
                        Spacer(modifier = Modifier.height(16.dp))  // Spacers can be optionally used for putting space between two elements
                        OutlinedTextField(value = "", onValueChange = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(value = "", onValueChange = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {}) {
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = "Login Now!")
                        }
                    }

                }
            }
        }
    }
}

@Composable

fun Greeting(name: String) {
    Text(
        text = "Hello $name!",

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}
