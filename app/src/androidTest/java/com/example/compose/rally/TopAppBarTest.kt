package com.example.compose.rally

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import com.example.compose.rally.ui.overview.OverviewBody
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        composeTestRule.setContent {
            Text(text = "test text")
        }
    }

    @Test
    fun rallyTopBarTest() {

        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = allScreens,
                    onTabSelected = {},
                    currentScreen = RallyScreen.Accounts
                )
            }
//               RallyTopAppBar(
//                   allScreens = allScreens,
//                   onTabSelected = {},
//                   currentScreen = RallyScreen.Accounts
//               )
        }

//        composeTestRule.onNodeWithContentDescription(RallyScreen.Accounts.name)
        composeTestRule.onNodeWithText(RallyScreen.Accounts.name)
            .assertIsSelected()
    }

    @Test
    fun rallyTopBarTestUpperCase() {

        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = allScreens,
                    onTabSelected = {},
                    currentScreen = RallyScreen.Accounts
                )
            }
        }
        //composeTestRule.onRoot().printToLog("currentLabelExists")
        composeTestRule.onNodeWithContentDescription(RallyScreen.Accounts.name.uppercase())
            .assertIsSelected()
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {},
                currentScreen = RallyScreen.Accounts
            )
        }
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")
        composeTestRule.onNode(
            hasText(RallyScreen.Accounts.name.uppercase()) and
                    hasParent(
                        hasContentDescription(RallyScreen.Accounts.name)
                    ),
            useUnmergedTree = true
        )
            .assertExists()
    }

    @Test
    fun overviewScreen_alertDisplayed(){
        composeTestRule.setContent {
            OverviewBody()
        }
        composeTestRule
            .onNodeWithText("Alerts")
            .assertIsDisplayed()
    }

}