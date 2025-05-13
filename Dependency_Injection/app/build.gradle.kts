plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)/* add this, ✅ It applies Dagger Hilt plugin (used for Dependency Injection in Android)
                                      Requires adding dependency in libs.versions.toml like: [plugins] dagger.hilt = { id = "com.google.dagger.hilt.android", version = "2.48" }*/
    kotlin("kapt") /*add this, ✅ It enables Kotlin Annotation Processing Tool (KAPT)
                     Required for Hilt/Dagger to generate code using annotations like @Inject, @HiltAndroidApp, etc.*/

}

android {
    namespace = "com.example.dependency_injection"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.dependency_injection"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.hilt.android) // ✅ Adds Hilt runtime to your project — provides core annotations like @Inject, @HiltAndroidApp, etc.
    // ❗ Required to use any Hilt-related features; missing this will cause "unresolved reference" errors.

    kapt(libs.hilt.android.compiler) // here instead of kapt() we could use ksp(), but it will depend on line 7 in this file , as there is provided kotlin("kapt"), so here also it is kapt, if there would be kotlin("ksp") then we will be using the ksp here
    /* ✅ Adds the Hilt annotation processor for generating Dagger-related code at compile time.
     ❗ Without this, Hilt won't be able to generate the necessary code for injection and you'll face compile-time errors.
     💡 If we are using kapt instead of ksp, just change ksp(...) to kapt(...) — the comments still apply the same way.} */
}