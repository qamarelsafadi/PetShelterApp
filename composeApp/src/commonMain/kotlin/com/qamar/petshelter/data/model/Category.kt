package com.qamar.petshelter.data.model

import org.jetbrains.compose.resources.DrawableResource
import petshelterap.composeapp.generated.resources.Res
import petshelterap.composeapp.generated.resources.cat1
import petshelterap.composeapp.generated.resources.cat2
import petshelterap.composeapp.generated.resources.cat3

data class Category(
    val image: DrawableResource,
    val name: String
) {
    companion object {
        val categoryList = listOf(
            Category(image = Res.drawable.cat1, "All"),
            Category(image = Res.drawable.cat2, "Cat"),
            Category(image = Res.drawable.cat3, "Dog"),
        )
    }
}