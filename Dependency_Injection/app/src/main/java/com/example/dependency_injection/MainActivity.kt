package com.example.dependency_injection

import android.os.Bundle
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
import com.example.dependency_injection.ui.theme.Dependency_InjectionTheme
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject

@AndroidEntryPoint
/** @AndroidEntryPoint : Used on Activities, Fragments, ViewModels, Services, etc. to request injection from Hilt.*/
/**
 * 🔍 @AndroidEntryPoint:
 * This annotation tells Hilt to generate the necessary code to perform dependency injection
 * in this Android class (e.g., Activity, Fragment, Service, etc.).
 *
 * Specifically in MainActivity, it allows you to use `@Inject` to request dependencies
 * like ViewModels, repositories, or any class that Hilt can provide.
 *
 * Every Android component that needs dependency injection must be annotated with @AndroidEntryPoint.
 * Without it, Hilt won't be able to inject dependencies and you'll get a runtime error.
 *
 * ✅ Required when you want to inject something into this class using @Inject
 * 🔧 Works by generating a base class that your component inherits from, enabling injection
 */
class MainActivity : ComponentActivity() {

    //@Inject lateinit var model: Model // 🔌 Yo Hilt, I want a Model — go look into your toolbox (DIModule) and figure out how to give it to me
    @Inject
    lateinit var car: Car // 🔌 Yo Hilt, I want a Car — go look into your toolbox (DIModule) and figure out how to give it to me

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dependency_InjectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    /*val car = Car(Model()) //type of Manual dependency injection
                    car.showCar()*/

                    car.showCar()

                }
            }
        }
    }
}

class Car(var model: Model) {
    fun showCar() {
        model.showMyModel()
        println("Where is the car")
    }
}

class Model(var chassis: Chassis) {
    fun showMyModel() {
        chassis.showChassisNO()
        println("This is my model")
    }

}

class Chassis() {
    fun showChassisNO() {
        println("23432")
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dependency_InjectionTheme {
        Greeting("Android")
    }
}
