package com.main.cryptotracking.domain.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.feat_tracking.presentation.ui.screen.TrackingScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = MainNavigationGraphRoutes.TRACKING_SCREEN) {
        composable(MainNavigationGraphRoutes.TRACKING_SCREEN) {
            TrackingScreen(
                modifier = Modifier.testTag(MainNavigationGraphRoutes.TRACKING_SCREEN)
            )
        }
    }
}

object MainNavigationGraphRoutes {
    const val TRACKING_SCREEN = "tracking_screen"
}
