package org.ippon.database

import org.ippon.models.RickAndMortyCharacter

class Repository {
    suspend fun getFavorites(): List<RickAndMortyCharacter> {
        TODO("Not yet implemented")
    }

    suspend fun addFavorite(character: RickAndMortyCharacter): Boolean {
        TODO("Not yet implemented")
    }

    suspend fun removeFavorite(character: RickAndMortyCharacter): Boolean {
        TODO("Not yet implemented")
    }
}