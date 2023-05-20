package com.main.cryptotracking.domain.navigation.main

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.main.cryptotracking.domain.navigation.authentication.AuthenticationNavigationGraph
import org.junit.Before
import org.junit.Rule

class TestMainNavigationGraph {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MainNavigationGraph(navController = navController)
        }
    }


}