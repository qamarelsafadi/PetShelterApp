package com.qamar.petshelter.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.qamar.petshelter.navigation.petAppGraph

@Composable
fun PetApp() {
    val navController = rememberNavController()
    val graph = navController.petAppGraph()
    NavHost(
        navController = navController,
        graph = graph
    )
}
