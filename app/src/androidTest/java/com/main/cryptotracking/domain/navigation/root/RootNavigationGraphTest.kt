package com.main.cryptotracking.domain.navigation.root

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.main.core.data.testing.TestingConstants
import com.main.cryptotracking.domain.navigation.authentication.AuthenticationNavigationGraphRoutes
import com.main.cryptotracking.domain.navigation.main.MainNavigationGraphRoutes
import org.junit.Rule
import org.junit.Test

class RootNavigationGraphTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Test
    fun testStartDestination() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            RootNavigationGraph(
                navController = navController
            )
        }
        val testTag = MainNavigationGraphRoutes.TRACKING_SCREEN
        val semanticsNoteInteraction = composeTestRule.onNodeWithTag(testTag = testTag)
        semanticsNoteInteraction.assertIsDisplayed()
    }

    @Test
    fun testAuthenticationNavGraph() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            RootNavigationGraph(
                navController = navController,
                startDestination = RootNavigationGraphRoutes.AUTHENTICATION
            )
        }
        val testTag = AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN
        val semanticsNoteInteraction = composeTestRule.onNodeWithTag(testTag = testTag)
        semanticsNoteInteraction.assertIsDisplayed()
    }

    @Test
    fun testMainNavGraph() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            RootNavigationGraph(
                navController = navController,
                startDestination = RootNavigationGraphRoutes.MAIN
            )
        }
        val testTag = MainNavigationGraphRoutes.TRACKING_SCREEN
        val semanticsNoteInteraction = composeTestRule.onNodeWithTag(testTag = testTag)
        semanticsNoteInteraction.assertIsDisplayed()
    }

    @Test
    fun testOnBoardingNavGraph() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            RootNavigationGraph(
                navController = navController,
                startDestination = RootNavigationGraphRoutes.ON_BOARDING
            )
        }
        val testTag = TestingConstants.testTagOnBoarding
        val semanticsNoteInteraction = composeTestRule.onNodeWithTag(testTag = testTag)
        semanticsNoteInteraction.assertIsDisplayed()
    }
}
