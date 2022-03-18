package org.ippon.rickandmorty.network.models

import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyCharacterREST(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: RickAndMortyLocation,
    val location: RickAndMortyLocation,
    val image: String
)

