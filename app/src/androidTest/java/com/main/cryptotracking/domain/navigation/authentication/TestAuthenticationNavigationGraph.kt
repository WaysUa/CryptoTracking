package com.main.cryptotracking.domain.navigation.authentication

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.main.core.data.testing.TestingConstants
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TestAuthenticationNavigationGraph {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AuthenticationNavigationGraph(
                navigateToTrackingScreen = {},
                navController = navController
            )
        }
    }

    @Test
    fun testStartDestinationInAuthenticationNavGraph() {
        val testTag = AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN
        val semanticsNoteInteraction = composeTestRule.onNodeWithTag(testTag = testTag)
        semanticsNoteInteraction.assertIsDisplayed()
    }

    @Test
    fun some() {
        val testTag = TestingConstants.testTagButtonNavigationToSignIn
        composeTestRule.onNodeWithTag(testTag = testTag).performClick()
        val route = navController.currentDestination?.route
        assertEquals(route, AuthenticationNavigationGraphRoutes.SIGN_IN_SCREEN)
    }
}