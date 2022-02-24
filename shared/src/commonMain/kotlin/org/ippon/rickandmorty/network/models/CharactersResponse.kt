package org.ippon.rickandmorty.network.models

import kotlinx.serialization.Serializable
import org.ippon.rickandmorty.network.RickAndMortyCharacterREST

@Serializable
data class CharactersResponse(val results: List<RickAndMortyCharacterREST>)