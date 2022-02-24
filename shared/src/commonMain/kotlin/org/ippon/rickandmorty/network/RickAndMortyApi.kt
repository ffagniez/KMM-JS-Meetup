package org.ippon.rickandmorty.network

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.ippon.rickandmorty.network.models.CharactersResponse

class RickAndMortyApi(private val endpoint: String = "https://rickandmortyapi.com") {

    private val httpClient = HttpClient() {
        install(Logging) {
            level = LogLevel.HEADERS
        }
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getCharacters(page: Int): CharactersResponse =
        httpClient.get { apiUrl("/api/character/?page=$page") }

    private fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            takeFrom(endpoint)
            encodedPath = path
        }
    }
}