package org.ippon.rickandmorty.models

import org.ippon.rickandmorty.network.RickAndMortyCharacterREST

data class RickAndMortyCharacter(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val gender: Gender,
    val origin: String,
    val location: String,
    val image: String
) {
    companion object {
        fun from(character: RickAndMortyCharacterREST): RickAndMortyCharacter =
            RickAndMortyCharacter(
                id = character.id,
                name = character.name,
                status = Status.safeValueOf(character.status),
                species = character.species,
                gender = Gender.safeValueOf(character.gender),
                origin = character.origin.name,
                location = character.location.name,
                image = character.image
            )
    }
}