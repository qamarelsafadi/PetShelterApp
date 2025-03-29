package com.qamar.petshelter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.qamar.petshelter.ui.PetApp
import com.qamar.petshelter.ui.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PetApp()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    SplashScreen(){}
}