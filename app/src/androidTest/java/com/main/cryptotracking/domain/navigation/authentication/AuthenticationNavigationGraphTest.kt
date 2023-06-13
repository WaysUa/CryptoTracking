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
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AuthenticationNavigationGraphTest {

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
    fun testStartDestination() {
        val testTag = AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN
        val semanticsNoteInteraction = composeTestRule.onNodeWithTag(testTag = testTag)
        semanticsNoteInteraction.assertIsDisplayed()
    }

    @Test
    fun testNavigationFromSignUpToSignIn() {
        val testTag = TestingConstants.testTagButtonNavigationToSignIn
        composeTestRule.onNodeWithTag(testTag = testTag).performClick()
        val route = navController.currentDestination?.route
        assertEquals(route, AuthenticationNavigationGraphRoutes.SIGN_IN_SCREEN)
    }

    @Test
    fun testNavigationFromSignInToSignUp() {
        val prevTestTag = TestingConstants.testTagButtonNavigationToSignIn
        composeTestRule.onNodeWithTag(testTag = prevTestTag).performClick()

        val testTag = TestingConstants.testTagButtonNavigationToSignUp
        composeTestRule.onNodeWithTag(testTag = testTag).performClick()
        val route = navController.currentDestination?.route
        assertEquals(route, AuthenticationNavigationGraphRoutes.SIGN_UP_SCREEN)
    }
}
