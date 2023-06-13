package com.main.cryptotracking.domain.navigation.authentication

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.feat_signin.presentation.ui.screen.SignInScreen
import com.main.feat_signup.presentation.ui.screen.SignUpScreen

@Composable
fun AuthenticationNavigationGraph(
    navigateToTrackingScreen: () -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN) {
            SignUpScreen(
                modifier = Modifier.testTag(AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN),
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
                onSuccessfulSignIn = {
                    navigateToTrackingScreen.invoke()
                }
            )
        }
    }
}

object AuthenticationNavigationGraphRoutes {
    const val SIGN_UP_SCREEN = "sign_up_screen"
    const val SIGN_IN_SCREEN = "sign_in_screen"
}
