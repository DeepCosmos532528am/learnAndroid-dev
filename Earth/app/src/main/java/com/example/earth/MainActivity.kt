package com.example.earth

import android.R
import android.R.attr.textStyle
import android.R.id.bold
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily.Companion.Cursive
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.earth.ui.theme.EarthTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // 🟢 Apply my app's custom theme styling (optional)
            EarthTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { sachin ->


                    var inputText by remember { mutableStateOf("") }
                    // 🔽 Arranges UI elements vertically
                    Column(

                        modifier = Modifier.padding(sachin).fillMaxSize().background(Color.LightGray) ,
                        horizontalAlignment = Alignment.CenterHorizontally,

                    ) {

                        // 📌 Display a static message for user instructions
                        Text(
                            text = "Please Enter, what Table you want? 🙂",
                            color = Color.Black
                        )

                        // 🖊️ Input field for the user to enter text (e.g. number or name)
                        TextField(
                            value = inputText,
                            onValueChange = {
                                inputText = it
                            }, // ← updates the state when user types
                            label = { Text("Enter your number")
                                    },
                            colors = textFieldColors(Color.White)


                        )

                        // 💬 Call a custom function and pass the current input
                        greetMe(inputText)

                        // 🔵 Decorative or branding text at the bottom
                        Text(
                            text = "Sachin Sharma",
                            color = Color.Blue,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }

    // 🧩 Custom composable function to show a message based on input
    @Composable
    fun greetMe(table: String) {

        val mytable = table.toIntOrNull()
        when {
            mytable == null -> {
                // ❌ Input is not a valid number (null after toIntOrNull)
                Text(text="Please enter the table number you want.", color = Color.Red,fontStyle = Italic , fontWeight = Bold   )

            }

            mytable.equals("") -> {
                Text(" ")
            }

            mytable < 1 -> {
                // ✅ It's a number, but less than 1
                Text(text="Please enter any natural number.", color = Color.Red)
            }

            else -> {
                // ✅ Valid natural number (1 or more)
                Text("The table for $mytable is:", color = Color.DarkGray)
                repeat(10) {
                    Text(text ="$mytable * ${it + 1} = ${mytable * (it + 1)}", color = Color.Black)
                }
            }
        }
    }
}

/* comment out for the line ,  var inputText by remember { mutableStateOf("") } from the code is :


 🧠 Core State Handling Concept in Jetpack Compose:

                 This line sets up a reactive variable that stores user input:
                     var inputText by remember { mutableStateOf("") }

                 1️⃣ -> `mutableStateOf("")` creates a mutable state variable that initially holds an empty string.
                       It means the value of this variable can change during runtime.

                 2️⃣ -> `remember { ... }` ensures that the state survives recomposition.
                       Without 'remember', inputText would reset every time the UI refreshes.

                 3️⃣ -> The `TextField` component is used to display an input box:
                       TextField(
                           value = inputText,
                           onValueChange = { inputText = it },
                           ...
                       )

                     - `value = inputText` binds the current value of inputText to what's shown in the field.
                     - `onValueChange = { inputText = it }` captures user input (from `it`) and updates `inputText`.

                 4️⃣ -> When `inputText` is updated, Jetpack Compose automatically **recomposes** (refreshes)
                       any part of the UI that reads from `inputText`. This is because Compose observes state changes.

                 ✅ So every time the user types, the following happens:
                     - `onValueChange` receives new input.
                     - That input updates `inputText`.
                     - Because `inputText` is a state (from `mutableStateOf`), the UI refreshes wherever it's used.
*/