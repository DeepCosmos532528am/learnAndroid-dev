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
    fun provideModel( chassis: Chassis): Model {
        return Model(chassis)
    }

    // ✅ This tells Hilt: "When someone needs a Chassis, use this function"
    fun provideChassis(): Chassis { // as here in this, the 'Chassis' is the interface and 'ChassisImpl' is the implementation, so in this case write 'interface name' as 'Return type' and the 'return type' as thh 'name of the class' which implements the interface
        return ChassisImpl() // class name
    }

    // ✅ This tells Hilt: "When someone needs a Car, use this function"
    @Provides
    fun provideCar(model: Model): Car {
        return Car(model)
    }
}
