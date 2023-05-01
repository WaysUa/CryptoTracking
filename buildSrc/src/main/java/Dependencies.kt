object Dependencies {

    object Compose {
        const val version = "1.4.3"

        const val composeUi = "androidx.compose.ui:ui"
        const val composeGraphics = "androidx.compose.ui:ui-graphics"
        const val composePreviewTooling = "androidx.compose.ui:ui-tooling-preview"
        const val composeMaterial3 = "androidx.compose.material3:material3:1.1.0-rc01"
        const val composeMaterial = "androidx.compose.material:material:1.4.2"
        const val accompanist = "com.google.accompanist:accompanist-systemuicontroller:0.31.1-alpha"
        const val composeLiveData = "androidx.compose.runtime:runtime-livedata:$version"

        object Debug {
            const val composeUiTooling = "androidx.compose.ui:ui-tooling"
            const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
        }
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.10.0"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
        const val activityCompose = "androidx.activity:activity-compose:1.7.1"
    }

    object Hilt {
        private const val version = "2.45"

        const val android = "com.google.dagger:hilt-android:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Navigation {
        private const val version = "2.6.0-beta01"

        const val navigationCompose = "androidx.navigation:navigation-compose:$version"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
        const val jUnitExt = "androidx.test.ext:junit:1.1.5"
        const val jUnitUi = "androidx.compose.ui:ui-test-junit4"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
    }
}