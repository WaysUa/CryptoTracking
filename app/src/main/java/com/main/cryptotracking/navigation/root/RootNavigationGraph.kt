package com.main.cryptotracking.navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.main.cryptotracking.navigation.authentication.AuthenticationNavigationGraph
import com.main.cryptotracking.navigation.main.MainNavigationGraph
import com.main.feat_onboarding.ui.screen.OnBoardingScreen

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        route = "root_graph",
        startDestination = startDestination
    ) {
        composable(route = RootNavigationGraphRoutes.ON_BOARDING) {
            OnBoardingScreen(
                popBackStack = {
                    navController.popBackStack()
                    navController.navigate(RootNavigationGraphRoutes.AUTHENTICATION)
                }
            )
        }
        composable(route = RootNavigationGraphRoutes.MAIN) {
            MainNavigationGraph()
        }
        composable(route = RootNavigationGraphRoutes.AUTHENTICATION) {
            AuthenticationNavigationGraph()
        }
    }
}

object RootNavigationGraphRoutes {
    const val MAIN = "main_graph"
    const val ON_BOARDING = "on_boarding_graph"
    const val AUTHENTICATION = "authentication"
}