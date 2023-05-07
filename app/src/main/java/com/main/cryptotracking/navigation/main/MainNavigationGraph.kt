package com.main.cryptotracking.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.feat_tracking.ui.screen.TrackingScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = MainNavigationGraphRoutes.MAIN_SCREEN) {
        composable(MainNavigationGraphRoutes.MAIN_SCREEN) {
            TrackingScreen()
        }
    }
}

object MainNavigationGraphRoutes {
    const val MAIN_SCREEN = "main_screen"
}