plugins {
    id(Plugins.Application.dependency)
    id(Plugins.Android.dependency)
    id(Plugins.Firebase.dependency)
    id(Plugins.Ktlint.depencency) version (Plugins.Ktlint.version)
}

android {
    namespace = Config.appModulePackageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.appModulePackageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

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
    debugImplementation(Dependencies.Compose.Debug.composeUiTooling)
    debugImplementation(Dependencies.Compose.Debug.composeUiTestManifest)
    // Unit Testing
    testImplementation(Dependencies.Test.Mockito.core)
    testImplementation(Dependencies.Test.Mockito.inline)
    testImplementation(Dependencies.Test.KotlinX.coroutines)
    testImplementation(Dependencies.Test.JUnit.core)
    // Android Testing
    androidTestImplementation(Dependencies.Test.Compose.navigation)
    androidTestImplementation(Dependencies.Test.Compose.jUnit)
    androidTestImplementation(Dependencies.Test.JUnit.core)
    androidTestImplementation(Dependencies.Test.Mockito.core)
    androidTestImplementation(Dependencies.Test.Mockito.inline)
    // Navigation
    implementation(Dependencies.Navigation.navigationCompose)
    // Koin
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.compose)
    // Firebase
    implementation(Dependencies.Firebase.auth)
    // Splash Screen
    implementation(Dependencies.SplashScreen.main)
    // Modules
    implementation(project(Modules.coreModule))
    implementation(project(Modules.coreDatasourceModule))
    implementation(project(Modules.featOnBoardingModule))
    implementation(project(Modules.featTrackingModule))
    implementation(project(Modules.featSignUpModule))
    implementation(project(Modules.featSignInModule))
}
