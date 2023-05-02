package com.main.cryptotracking.navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.cryptotracking.navigation.main.MainNavigationGraph

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    startDestination: String = RootNavigationGraphRoutes.MAIN,
) {
    NavHost(
        navController = navController,
        route = RootNavigationGraphRoutes.ROOT,
        startDestination = startDestination
    ) {
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