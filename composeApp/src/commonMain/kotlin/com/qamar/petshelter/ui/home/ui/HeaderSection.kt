package com.qamar.petshelter.ui.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import petshelterap.composeapp.generated.resources.Res
import petshelterap.composeapp.generated.resources.logo
import petshelterap.composeapp.generated.resources.notification

@Composable
fun HeaderSection() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Logo"
        )
        Icon(
            painter = painterResource(Res.drawable.notification),
            contentDescription = "Notificaiton",
            tint = Color.Unspecified
        )
    }
}
