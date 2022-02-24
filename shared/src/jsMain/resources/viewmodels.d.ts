declare module viewmodels {
    export class CharactersViewModel {
          constructor(getResult: (result: Response<[RickAndMortyCharacter]>) => void);
          getResult: (result: Response<[RickAndMortyCharacter]>) => void;
          getFirstPage(): void;
          getMoreCharacters(): void;
    }
}