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
    @Binding var characters: [RickAndMortyCharacter]
    var onReachBottom: () -> Void

    var body: some View {
        ScrollView {
            LazyVStack {
                ForEach(characters.indices, id: \.self) { index in
                    CharacterRow(character: characters[index])
                        .onAppear {
                            if index == characters.indices.last {
                                onReachBottom()
                            }
                        }
                }
            }
        }
    }
}

struct CharactersList_Previews: PreviewProvider {
    static var previews: some View {
        CharactersList(characters: .constant([])) {}
    }
}
