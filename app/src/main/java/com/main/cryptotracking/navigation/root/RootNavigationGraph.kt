package com.main.cryptotracking.navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.main.cryptotracking.navigation.main.MainNavigationGraph
import com.main.feat_onboarding.screen.OnBoardingScreen

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    startDestination: String = RootNavigationGraphRoutes.ON_BOARDING,
) {
    NavHost(
        navController = navController,
        route = RootNavigationGraphRoutes.ROOT,
        startDestination = startDestination
    ) {
        composable(route = RootNavigationGraphRoutes.ON_BOARDING) {
            OnBoardingScreen(
                popBackStack = {
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
    const val ROOT = "root_graph"
    const val MAIN = "main_graph"
    const val ON_BOARDING = "on_boarding"
}