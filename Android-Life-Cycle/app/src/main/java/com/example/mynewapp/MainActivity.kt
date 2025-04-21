package com.example.mynewapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewapp.ui.theme.MyNewAppTheme

class MainActivity : ComponentActivity() {

    // Called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()

        // Enables drawing edge-to-edge UI
        enableEdgeToEdge()

        // Set the UI content of this activity using Jetpack Compose
        setContent {
            MyNewAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    // Called when the activity becomes visible to the user
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    // Called when the activity starts interacting with the user (comes to foreground)
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    // Called when the activity is partially hidden (another activity comes in front)
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    // Called when the activity is no longer visible to the user
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    // Called before the activity is destroyed (e.g. user exits or system kills it)
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainDestroy", "onDestroy called")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show() // Fixed message
    }
}

// Reusable Composable function that displays greeting text
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// Preview of Greeting Composable inside Android Studio
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNewAppTheme {
        Greeting("Android")
    }
}
/*
🧠 Android Activity Lifecycle Notes:

The Android Activity Lifecycle defines a set of states and transitions that an Activity goes through during its lifetime. Below is a summary:

- onCreate(): Called once when the activity is first created. Use it to initialize components.
- onStart(): Called when the activity is becoming visible to the user.
- onResume(): Called when the activity starts interacting with the user.
- onPause(): Called when another activity is taking focus; pause ongoing tasks.
- onStop(): Called when the activity is no longer visible.
- onDestroy(): Called before the activity is destroyed; clean up any resources.

Each method is important for managing resources, saving UI state, and handling background tasks properly.

*/

