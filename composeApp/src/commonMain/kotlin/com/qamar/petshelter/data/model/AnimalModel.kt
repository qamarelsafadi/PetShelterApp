package com.qamar.petshelter.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimalModel(
    @SerialName("description")
    val description: String?,
    @SerialName("diet")
    val diet: String?,
    @SerialName("family")
    val family: String?,
    @SerialName("habitat")
    val habitat: String?,
    @SerialName("height_cm")
    val heightCm: Float?,
    @SerialName("id")
    val id: Int?,
    @SerialName("image")
    val image: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("place_of_found")
    val placeOfFound: String?,
    @SerialName("species")
    val species: String?,
    @SerialName("weight_kg")
    val weightKg: Float?
)