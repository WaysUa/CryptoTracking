package com.main.cryptotracking.domain.navigation.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import com.main.core.data.testing.TestingConstants
import com.main.cryptotracking.domain.navigation.authentication.AuthenticationNavigationGraph
import com.main.cryptotracking.domain.navigation.main.MainNavigationGraph
import com.main.feat_onboarding.presentation.ui.screen.OnBoardingScreen

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    startDestination: String = RootNavigationGraphRoutes.MAIN,
    firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    NavHost(
        navController = navController,
        route = "root_graph",
        startDestination = startDestination
    ) {
        composable(route = RootNavigationGraphRoutes.ON_BOARDING) {
            OnBoardingScreen(
                modifier = Modifier.testTag(TestingConstants.testTagOnBoarding),
                popBackStack = {
                    navController.popBackStack()
                    if (
                        firebaseAuth.currentUser != null &&
                        firebaseAuth.currentUser?.isEmailVerified == true
                    ) {
                        navController.navigate(RootNavigationGraphRoutes.MAIN)
                    } else {
                        navController.navigate(RootNavigationGraphRoutes.AUTHENTICATION)
                    }
                }
            )
        }
        composable(route = RootNavigationGraphRoutes.AUTHENTICATION) {
            AuthenticationNavigationGraph(
                navigateToTrackingScreen = {
                    navController.popBackStack()
                    navController.navigate(RootNavigationGraphRoutes.MAIN)
                }
            )
        }
        composable(route = RootNavigationGraphRoutes.MAIN) {
            MainNavigationGraph()
        }
    }
}

object RootNavigationGraphRoutes {
    const val MAIN = "main_graph"
    const val ON_BOARDING = "on_boarding_graph"
    const val AUTHENTICATION = "authentication_graph"
}
