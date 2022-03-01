package org.ippon.rickandmorty.service

import org.ippon.rickandmorty.models.RickAndMortyCharacter
import org.ippon.rickandmorty.network.RickAndMortyApi
import org.ippon.rickandmorty.service.models.Response

class RickAndMortyService(val api: RickAndMortyApi) {
    suspend fun getCharacters(page: Int): Response<List<RickAndMortyCharacter>> {
        return try {
            Response.Success(api.getCharacters(page).results.map { RickAndMortyCharacter.from(it) })
        } catch (e: Exception) {
            Response.CustomError(e)
        }
    }
}