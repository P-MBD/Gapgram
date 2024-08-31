plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("org.jetbrains.kotlin.kapt") version "1.8.0" apply false
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.45")
        classpath("io.realm:realm-gradle-plugin:10.16.0")
    }
}

allprojects {
    // repositories block is removed from here
}
