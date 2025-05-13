// Top-level build file where you can add configuration options common to all sub-projects/modules.

/*here we are linking the plugin from the TOML file, giving it the green light to be used, but not turning it on yet.*/
/*These lines link the plugins you defined in the libs.versions.toml file, but don’t apply them yet — so they’re available to use later in specific modules if needed.*/
/*"It means that I want to make the Android application plugin available, but don’t apply it yet here."*/
/*It helps centralize plugin versions (cleaner, reusable) and lets you apply them only where needed (like inside app/build.gradle.kts).*/
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
   // id("com.google.dagger.hilt.android") version "2.56.2" apply false
   // just know this , this is also one of the way to use the dependency , but the we have moved to
   // another way to do so , that is by using the build.gradle.kts file + libs.versions.toml file.

    // after defining the dagger-hilt plugin in .toml file, lets make the plugin available to be used.
   alias(libs.plugins.dagger.hilt) apply false
}
/*🔍 What is alias(...)?
It's a way to use the plugin name (alias) defined in your libs.versions.toml file instead of writing the full ID and version again.*/
/*Inside alias(...), you give the plugin reference (alias) that matches the name you defined in your libs.versions.toml file under [plugins].*/
