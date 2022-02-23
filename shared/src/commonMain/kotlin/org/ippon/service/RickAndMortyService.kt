package org.ippon.service

import org.ippon.database.Repository
import org.ippon.models.RickAndMortyCharacter
import org.ippon.network.RickAndMortyApi
import org.ippon.service.models.Response

class RickAndMortyService(val api: RickAndMortyApi, val repository: Repository) {
    suspend fun getCharacters(page: Int): Response<List<RickAndMortyCharacter>> {
        return try {
            Response.Success(api.getCharacters(page).results.map { RickAndMortyCharacter.from(it) })
        } catch (e: Exception) {
            Response.CustomError(e)
        }
    }

    suspend fun getFavorites(): Response<List<RickAndMortyCharacter>> {
        return try {
            Response.Success(repository.getFavorites())
        } catch (e: Exception) {
            Response.CustomError(e)
        }
    }

    suspend fun addFavorite(character: RickAndMortyCharacter): Response<Boolean> {
        return try {
            Response.Success(repository.addFavorite(character))
        } catch (e: Exception) {
            Response.CustomError(e)
        }
    }

    suspend fun removeFavorite(character: RickAndMortyCharacter): Response<Boolean> {
        return try {
            Response.Success(repository.removeFavorite(character))
        } catch (e: Exception) {
            Response.CustomError(e)
        }
    }
}