package com.qamar.petshelter.data.model

import org.jetbrains.compose.resources.DrawableResource

data class Animal(
    val image: DrawableResource,
    val inFav: Boolean,
    val name: String,
    val age: Int,
    val family: String,
    val category: Category
)
