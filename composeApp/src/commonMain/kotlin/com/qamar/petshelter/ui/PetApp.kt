package com.qamar.petshelter.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.qamar.petshelter.navigation.Screen
import com.qamar.petshelter.ui.home.HomeScreen

@Composable
fun PetApp() {
    val navController = rememberNavController()
    val graph = navController.createGraph(
        startDestination = Screen.SplashScreen.name
    ) {
        composable(Screen.SplashScreen.name) {
            SplashScreen {
                navController.navigate(Screen.HomeScreen.name)
            }
        }
        composable(Screen.HomeScreen.name) {
            HomeScreen()
        }
    }

    NavHost(
        navController = navController,
        graph = graph
    )
}