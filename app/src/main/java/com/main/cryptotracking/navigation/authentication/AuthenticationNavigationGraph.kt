package com.main.cryptotracking.navigation.authentication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.feat_signin.ui.screen.SignInScreen
import com.main.feat_signup.ui.screen.SignUpScreen

@Composable
fun AuthenticationNavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN) {
        composable(AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN) {
            SignUpScreen(
                onGoToSignInClicked = {
                    navController.popBackStack()
                    navController.navigate(AuthenticationNavigationGraphRoutes.SIGN_IN_SCREEN)
                }
            )
        }
        composable(AuthenticationNavigationGraphRoutes.SIGN_IN_SCREEN) {
            SignInScreen(
                onGoToSignUpClicked = {
                    navController.popBackStack()
                    navController.navigate(AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN)
                },
                onSignInCLicked = {
                    // todo handle sign in logic
                }
            )
        }
    }
}

object AuthenticationNavigationGraphRoutes {
    const val SIGN_UP_SCREEN = "sign_up_screen"
    const val SIGN_IN_SCREEN = "sign_in_screen"
}