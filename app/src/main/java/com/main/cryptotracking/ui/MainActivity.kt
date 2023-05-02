package com.main.cryptotracking.ui

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.main.core.ui.theme.CryptoTrackingTheme
import com.main.core.ui.theme.DarkBackgroundAppIcon
import com.main.cryptotracking.navigation.root.RootNavigationGraphRoutes
import com.main.cryptotracking.navigation.root.RootNavigationGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTrackingTheme {
                val navController = rememberNavController()
                RootNavigationGraph(navController = navController)
            }
        }
    }
}