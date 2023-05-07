package com.main.cryptotracking.navigation.authentication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.main.feat_signup.ui.screen.SignUpScreen

@Composable
fun AuthenticationNavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = MainNavigationGraphRoutes.SIGN_UP_SCREEN) {
        composable(MainNavigationGraphRoutes.SIGN_UP_SCREEN) {
            SignUpScreen()
        }
    }
}

object MainNavigationGraphRoutes {
    const val SIGN_UP_SCREEN = "sign_up_screen"
}