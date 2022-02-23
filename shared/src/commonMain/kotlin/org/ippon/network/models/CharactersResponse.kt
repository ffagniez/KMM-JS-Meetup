package org.ippon.network.models

import kotlinx.serialization.Serializable
import org.ippon.network.RickAndMortyCharacterREST

@Serializable
data class CharactersResponse(val results: List<RickAndMortyCharacterREST>)