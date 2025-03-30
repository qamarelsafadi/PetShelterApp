package com.qamar.petshelter.data.model

import org.jetbrains.compose.resources.DrawableResource
import petshelterap.composeapp.generated.resources.Res
import petshelterap.composeapp.generated.resources.cat1
import petshelterap.composeapp.generated.resources.cat2
import petshelterap.composeapp.generated.resources.cat3

data class Category(
    val image: DrawableResource,
    val name: String
){
    companion object {
        val categoryImagesList = listOf(Res.drawable.cat1, Res.drawable.cat2, Res.drawable.cat3)
        fun MutableList<Category?>.addAllSectionForCategoryList(){
            this.add(0, Category(name = "All", image = Res.drawable.cat3))
        }
    }
}