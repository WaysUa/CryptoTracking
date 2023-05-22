package com.main.cryptotracking.domain.navigation.main

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainNavigationGraphTest {

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

    @Test
    fun testStartDestinationInMainNavGraph() {
        val testTag = MainNavigationGraphRoutes.TRACKING_SCREEN
        val semanticsNoteInteraction = composeTestRule.onNodeWithTag(testTag = testTag)
        semanticsNoteInteraction.assertIsDisplayed()
    }
}