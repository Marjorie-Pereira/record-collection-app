plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.androidx.navigation.safe.args)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.ulbra.kotlin_record_collection_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ulbra.kotlin_record_collection_app"
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
        dataBinding=true
        viewBinding=true
    }
}

dependencies {
    implementation(libs.lifecycle.livedata)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.androidx.room.common.jvm)
    ksp(libs.room.compiler)
    annotationProcessor(libs.room.compiler)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.serialization)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.databinding.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.glide)
    ksp(libs.glide.compiler)
}