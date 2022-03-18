package org.ippon.rickandmorty.network.models

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(val results: List<RickAndMortyCharacterREST>)