package com.main.cryptotracking.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.main.cryptotracking.screen.MainScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController = rememberNavController(),
    systemUiController: SystemUiController = rememberSystemUiController()
) {
    NavHost(navController = navController, startDestination = MainNavigationGraphRoutes.MAIN_SCREEN) {
        composable(MainNavigationGraphRoutes.MAIN_SCREEN) {
            MainScreen()
        }
    }
}

object MainNavigationGraphRoutes {
    const val MAIN_SCREEN = "main_screen"
}