package com.main.cryptotracking.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.main.core.ui.theme.CryptoTrackingTheme
import com.main.cryptotracking.navigation.root.RootNavigationGraph
import com.main.cryptotracking.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CryptoTrackingTheme {
                val navController = rememberNavController()
                val startDestination = mainViewModel.startDestination.value
                RootNavigationGraph(
                    navController = navController,
                    startDestination = startDestination
                )
            }
        }
    }
}