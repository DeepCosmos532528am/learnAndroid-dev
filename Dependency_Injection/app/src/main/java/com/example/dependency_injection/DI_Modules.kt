package com.example.dependency_injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Qualifier

// ✅ Marks this file as a Dagger-Hilt Module
@Module

// ✅ Defines how long the provided dependency should live
// SingletonComponent means: Live as long as the Application
@InstallIn(SingletonComponent::class)
object DIModule {

    // ✅ This tells Hilt: "When someone needs a Model, use this function"
    @Provides
    fun provideModel(@Dev chassis: Chassis): Model { //now here by @Dev annotation or by @Named("dev") annotation depends on what is used to mark Chassis(e.g. @Named("dev") or @Dev), this is specified that the version for chassis should be taken the Dev version! Similarly could take Test also by @Test annotation
        return Model(chassis)
    }


    // In this case, we have two Chassis providers, so we use custom qualifiers @Dev and @Test
    @Qualifier // ✅ @Qualifier is used to differentiate between objects of the same type
// ✅ @Retention(BINARY) means this annotation will be available at compile-time and in the bytecode,
// so Hilt can see and use it, but it won't be available at runtime via reflection (which is fine for DI)
    @Retention(AnnotationRetention.BINARY)
    annotation class Dev  // 🔧 Used to mark Chassis for the Development environment

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Test // 🧪 Used to mark Chassis for the Testing environment

    @Dev // Instead of this we can also use @Named("dev")
    @Provides
    fun provideChassis(): Chassis { // Hilt uses return type + qualifier to distinguish,
        return Chassis()
    }

    @Test // Instead of this we can also use @Named("test")
    @Provides
    fun provideChassis1(): Chassis { // Hilt uses return type + qualifier to distinguish
        return Chassis()
    }

    @Provides // ✅ @Qualifier is used to differentiate between objects of the same type
    fun provideCar(model: Model): Car {
        return Car(model)
    }
}

/** //IMPORTANT NOTE:
 * These are the environment levels or stages of a software product's lifecycle — basically, the different setups or "environments" where the product is developed, tested, validated, and finally released to users.
 *
 * They are not about "scale" themselves, but the phases your product goes through before it reaches the final, scaled production environment where many users use it.
 *
 * In short:
 *
 * Dev,
 * Test,
 * UAT(User Acceptance Testing),
 * Production
 * are 4 environments or stages of building and releasing software*/


/**✅ Why two different versions of Chassis but same type!
You created two different versions of the same type (Chassis), and used custom tags (@Dev and @Test) to tell Hilt which one is which.

Then you told Hilt how to build a Car (which needs a Model, which needs a Chassis).

🔍 Why We Did This (Significance)
When you have multiple objects of the same type, Hilt won’t know which one to inject unless you give it a clue.
That clue is called a @Qualifier (in your case, @Dev and @Test).

Without qualifiers, Hilt would throw an error:

"Multiple bindings for type Chassis, but no way to choose between them."

💡 Real-World Analogy
Imagine you're a car factory.
You can make two types of Chassis:

A normal Dev Chassis for internal testing.

A Test Chassis for crash tests.

But when someone in your factory asks for a Chassis, how do you know which one they want?

You solve this by putting labels (like @Dev or @Test) on each and asking them to specify the label when requesting.

🚀 Real-World Popular Example
In companies like Netflix, Amazon, or Google, they often:

Use fake APIs or mock data (Test) in testing environments.

Use real APIs (Dev or Prod) when testing features internally or running in production.

So they create different versions of the same dependency, just like you're doing with Chassis, and switch between them using qualifiers.*/