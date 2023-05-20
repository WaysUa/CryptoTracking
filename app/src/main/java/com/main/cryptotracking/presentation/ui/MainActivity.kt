package com.main.cryptotracking.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.main.core.res.theme.CryptoTrackingTheme
import com.main.cryptotracking.domain.navigation.root.RootNavigationGraph
import com.main.cryptotracking.presentation.viewmodel.MainViewModel
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
                    startDestination = startDestination,
                )
            }
        }
    }
}