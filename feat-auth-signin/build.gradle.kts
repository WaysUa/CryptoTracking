plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = Config.featAuthSignInModulePackageName
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        @Suppress("UnstableApiUsage")
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    @Suppress("UnstableApiUsage")
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }
    packagingOptions {
        resources {
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {
    // Android
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.lifecycleKtx)
    implementation(Dependencies.Android.activityCompose)
    // Compose
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeGraphics)
    implementation(Dependencies.Compose.composePreviewTooling)
    implementation(Dependencies.Compose.composeMaterial3)
    implementation(Dependencies.Compose.composeMaterial)
    implementation(Dependencies.Compose.accompanist)
    implementation(Dependencies.Compose.composeLiveData)
    implementation(Dependencies.Compose.icons)
    debugImplementation(Dependencies.Compose.Debug.composeUiTooling)
    debugImplementation(Dependencies.Compose.Debug.composeUiTestManifest)
    // Testing
    // Koin
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.compose)
    // Firebase
    implementation(Dependencies.Firebase.auth)
    // Modules
    implementation(project(Modules.coreModule))
    implementation(project(Modules.coreDatasourceModule))
}