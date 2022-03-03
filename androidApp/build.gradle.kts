plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2-native-mt")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.fragment:fragment-ktx:1.4.1")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")

}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "org.ippon.myapplication.android"
        minSdkVersion(21)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }

        buildFeatures {
            viewBinding = true
        }
    }
}