package com.example.dependency_injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

object DI_Modules {
    @Module    // ✅ Marks this file as a Dagger-Hilt Module


// ✅ Defines how long the provided dependency should live
// SingletonComponent means: Live as long as the Application
    @InstallIn(SingletonComponent::class)
    object DIModule {

        // ✅ This tells Hilt: "When someone needs a Chassis, use this function"
        @Provides
        fun provideChassis(): Chassis {
            return Chassis()
        }

        // ✅ This tells Hilt: "When someone needs a Model, use this function"
        @Provides
        fun provideModel(chassis: Chassis): Model {
            return Model(chassis)
        }

        // ✅ This tells Hilt: "When someone needs a Car, use this function"
        @Provides
        fun provideCar(model: Model): Car {
            return Car(model)
        }
    }

}