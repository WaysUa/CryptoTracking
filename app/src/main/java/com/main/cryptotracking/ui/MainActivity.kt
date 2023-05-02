package com.main.cryptotracking.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.main.core.ui.theme.CryptoTrackingTheme
import com.main.cryptotracking.navigation.root.RootNavigationGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            CryptoTrackingTheme {
                val navController = rememberNavController()
                RootNavigationGraph(navController = navController)
            }
        }
    }
}