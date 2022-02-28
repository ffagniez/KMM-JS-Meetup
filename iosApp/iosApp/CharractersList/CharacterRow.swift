//
//  CharacterRow.swift
//  iosApp
//
//  Created by Raphaël Berthomé on 25/01/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CharacterRow: View {

    var character: RickAndMortyCharacter

    var body: some View {
        VStack {
            AsyncImage(url: URL(string: character.image))
                .aspectRatio(1, contentMode: .fill)
            Text(character.name)
            Text("\(character.status)")
        }
    }
}

struct CharacterRow_Previews: PreviewProvider {
    static var previews: some View {
        CharacterRow(character: RickAndMortyCharacter(id: 12, name: "Test", status: Status.alive, species: "Human", gender: Gender.male, origin: "OSEF", location: "OSEF", image: "https://rickandmortyapi.com/api/character/avatar/127.jpeg"))
    }
}
