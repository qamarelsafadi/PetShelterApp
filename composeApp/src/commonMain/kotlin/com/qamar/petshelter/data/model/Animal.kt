package com.qamar.petshelter.data.model

import org.jetbrains.compose.resources.DrawableResource
import petshelterap.composeapp.generated.resources.Res
import petshelterap.composeapp.generated.resources.animal1
import petshelterap.composeapp.generated.resources.animal2
import petshelterap.composeapp.generated.resources.animal3
import petshelterap.composeapp.generated.resources.cat2
import petshelterap.composeapp.generated.resources.cat3

data class Animal(
    val image: DrawableResource,
    val inFav: Boolean,
    val name: String,
    val age: Int,
    val family: String,
    val category: Category
) {
    companion object {
        val animalList = listOf(
            Animal(
                image = Res.drawable.animal1,
                inFav = false,
                name = "Jerrica",
                age = 2,
                family = "Tucker",
                category = Category(image = Res.drawable.cat2, name = "Cat")
            ),
            Animal(
                image = Res.drawable.animal2,
                inFav = false,
                name = "Aziz",
                age = 8,
                family = "Lainey",
                category = Category(image = Res.drawable.cat2, name = "Cat")
            ),
            Animal(
                image = Res.drawable.animal3,
                inFav = true,
                name = "Kasia",
                age = 9,
                family = "Tam",
                category = Category(image = Res.drawable.cat3, name = "Dog")
            ),
            Animal(
                image = Res.drawable.animal1,
                inFav = false,
                name = "Jerrica",
                age = 2,
                family = "Tucker",
                category = Category(image = Res.drawable.cat2, name = "Cat")
            ),
            Animal(
                image = Res.drawable.animal2,
                inFav = false,
                name = "Aziz",
                age = 8,
                family = "Lainey",
                category = Category(image = Res.drawable.cat2, name = "Cat")
            ),
            Animal(
                image = Res.drawable.animal3,
                inFav = true,
                name = "Kasia",
                age = 9,
                family = "Tam",
                category = Category(image = Res.drawable.cat3, name = "Dog")
            ),
            Animal(
                image = Res.drawable.animal1,
                inFav = false,
                name = "Jerrica",
                age = 2,
                family = "Tucker",
                category = Category(image = Res.drawable.cat2, name = "Cat")
            ),
            Animal(
                image = Res.drawable.animal2,
                inFav = false,
                name = "Aziz",
                age = 8,
                family = "Lainey",
                category = Category(image = Res.drawable.cat2, name = "Cat")
            ),
            Animal(
                image = Res.drawable.animal3,
                inFav = true,
                name = "Kasia",
                age = 9,
                family = "Tam",
                category = Category(image = Res.drawable.cat3, name = "Dog")
            )
        )
    }
}
