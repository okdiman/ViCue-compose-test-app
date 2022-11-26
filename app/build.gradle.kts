plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "okunev.projects.vicue_soft_okunev_test_app"
    compileSdk = 33

    defaultConfig {
        applicationId = "okunev.projects.vicue_soft_okunev_test_app"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    packagingOptions {
        packagingOptions {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}

dependencies {
    implementation(Libraries.Coil.core)
    implementation(Libraries.Coil.compose)
    implementation(Libraries.Compose.material)
    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.tooling)
    implementation(Libraries.Core.composeActivity)
    implementation(Libraries.Core.ktx)
    implementation(Libraries.Core.lifecycle)
    implementation(Libraries.ExoPlayer.core)
    implementation(Libraries.ExoPlayer.ui)
    implementation(Libraries.Koin.core)
    implementation(Libraries.Koin.android)
    implementation(Libraries.KViewModel.core)
    implementation(Libraries.KViewModel.compose)
    implementation(Libraries.Retrofit.core)
    implementation(Libraries.Retrofit.converter)
}