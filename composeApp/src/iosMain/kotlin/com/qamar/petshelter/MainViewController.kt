package com.qamar.petshelter

import androidx.compose.ui.window.ComposeUIViewController
import com.qamar.petshelter.ui.PetApp
import com.qamar.petshelter.ui.home.HomeScreen

fun MainViewController() = ComposeUIViewController { PetApp() }