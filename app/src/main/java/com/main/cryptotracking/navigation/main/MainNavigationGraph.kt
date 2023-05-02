package com.main.cryptotracking.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.main.cryptotracking.navigation.root.RootNavigationGraphRoutes
import com.main.cryptotracking.screen.MainScreen
import com.main.feat_splash_screen.screen.SplashScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController = rememberNavController(),
    systemUiController: SystemUiController = rememberSystemUiController()
) {
    NavHost(navController = navController, startDestination = MainNavigationGraphRoutes.SPLASH_SCREEN) {
        composable(MainNavigationGraphRoutes.SPLASH_SCREEN) {
            SplashScreen(systemUiController) {
                navController.popBackStack()
                navController.navigate(MainNavigationGraphRoutes.MAIN_SCREEN)
            }
        }

        composable(MainNavigationGraphRoutes.MAIN_SCREEN) {
            MainScreen(navController)
        }
    }
}

object MainNavigationGraphRoutes {
    const val SPLASH_SCREEN = "splash_screen"
    const val MAIN_SCREEN = "main_screen"
}