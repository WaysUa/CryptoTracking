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

    object Koin {
        private const val version = "3.4.0"

        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
    }

    object Navigation {
        private const val version = "2.6.0-beta01"

        const val navigationCompose = "androidx.navigation:navigation-compose:$version"
    }

    object Pager {
        private const val version = "0.26.4-beta"

        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:$version"
    }

    object DataStore {
        private const val version = "1.0.0"

        const val main = "androidx.datastore:datastore-preferences:$version"
    }

    object SplashScreen {
        const val main = "androidx.core:core-splashscreen:1.0.1"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
        const val jUnitExt = "androidx.test.ext:junit:1.1.5"
        const val jUnitUi = "androidx.compose.ui:ui-test-junit4"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
    }
}