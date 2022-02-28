//
//  CharactersViewModel.swift
//  iosApp
//
//  Created by Alexandre FALTOT on 28/02/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import shared
import SwiftUI

class MyCharactersViewModel: CharactersViewModel, ObservableObject {
    @Published var state: State<[RickAndMortyCharacter]> = .idle
    var fetchedCharacters: [RickAndMortyCharacter] = []

    func initialize() {
        onResult = { [weak self] in
            switch $0 {
            case (let success as ResponseSuccess<NSArray>):
                self?.fetchedCharacters += success.result?.compactMap { $0 as? RickAndMortyCharacter } ?? []
                self?.state = .ready(data: self?.fetchedCharacters ?? [])
            case is ResponseCustomError<NSArray>:
                self?.state = .error(error: RMError())
            case _ where self?.fetchedCharacters.count == 0:
                self?.state = .loading
            default:
                return
            }
        }
    }
}

class RMError: Error {}

enum State<T> {
    case loading
    case idle
    case ready(data: T)
    case error(error: Error)
}
