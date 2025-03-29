package com.qamar.petshelter.data.remote

import com.qamar.petshelter.data.model.AnimalModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

object Ktor {
    private const val BASE_URL = "https://freetestapi.com/api/v1/"
    val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(BASE_URL)
        }
    }

    suspend fun HttpClient.getAnimalList() =
        this.get("animals").body<List<AnimalModel>>()

}