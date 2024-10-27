plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.uijust"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.uijust"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // circular progress bar
    implementation(libs.circularseekbar)

    // Navigation component
    implementation (libs.navigation.fragment)
    implementation (libs.navigation.ui)

    // camera
    implementation (libs.camera.core)
    implementation (libs.androidx.camera.camera2)
    implementation (libs.camera.lifecycle)
    implementation (libs.camera.view)
    implementation (libs.camera.extensions)
}