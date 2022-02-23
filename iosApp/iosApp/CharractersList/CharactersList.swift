//
//  CharactersList.swift
//  iosApp
//
//  Created by Raphaël Berthomé on 01/02/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CharactersList: View {
    var characters: [RickAndMortyCharacter]

    var body: some View {
        List(characters, id: \.id) { character in
            CharacterRow(character: character)
        }
    }
}

struct CharactersList_Previews: PreviewProvider {
    static var previews: some View {
        CharactersList(characters :[])
    }
}
