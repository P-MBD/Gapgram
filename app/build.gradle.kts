plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
    id("realm-android")
}

android {
    namespace = "com.example.gapgram"
    compileSdk = 34
    viewBinding {
        enable = true
    }
    buildFeatures {
        aidl = true
    }
    defaultConfig {
        applicationId = "com.example.gapgram"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Core Android dependencies
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.activity:activity-ktx:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")
    implementation("io.realm:realm-android-library:10.16.0")
    kapt("io.realm:realm-annotations:10.16.0")
    kapt("io.realm:realm-gradle-plugin:10.16.0")

    // Glide dependencies
    implementation("com.github.bumptech.glide:glide:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")
    // اضافه کردن جدیدترین نسخه‌ها برای کتابخانه‌های AndroidX
    implementation("androidx.activity:activity-ktx:1.8.0") // مطمئن شوید که آخرین نسخه را استفاده می‌کنید
    implementation("androidx.core:core-ktx:1.12.0") // یا آخرین نسخه موجود
    implementation("com.karumi:dexter:6.0.0")  // آخرین نسخه موجود
    implementation("com.squareup.okhttp3:okhttp:4.9.3") // اضافه کردن وابستگی okhttp3
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3") // اضافه کردن وابستگی logging-interceptor
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Test dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.dagger:dagger:2.44") // آخرین نسخه dagger
    annotationProcessor ("com.google.dagger:dagger-compiler:2.44")

    // برای Hilt اگر استفاده می‌کنید
    implementation ("com.google.dagger:hilt-android:2.44")
    kapt ("com.google.dagger:hilt-android-compiler:2.44")

    // Add your other dependencies here
}
