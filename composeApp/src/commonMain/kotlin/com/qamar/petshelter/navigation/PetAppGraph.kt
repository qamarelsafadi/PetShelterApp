package com.qamar.petshelter.navigation

import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.qamar.petshelter.ui.SplashScreen
import com.qamar.petshelter.ui.home.HomeScreen

fun NavController.petAppGraph() =
    this.createGraph(
        startDestination = Screen.SplashScreen.name
    ) {
        composable(Screen.SplashScreen.name) {
            SplashScreen {
                this@petAppGraph.navigate(Screen.HomeScreen.name)
            }
        }
        composable(Screen.HomeScreen.name) {
            HomeScreen()
        }
    }
