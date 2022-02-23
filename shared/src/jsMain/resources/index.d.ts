declare module "rickandmorty" {
  export class CharactersViewModel {
    constructor(getResult: (result: Response<[RickAndMortyCharacter]>) => void);
    getFirstPage(): void;
    getMoreCharacters(): void;
  }
  export class Response<T> {}
  export class Loading<T> extends Response<T> {}
  export class Success<T> extends Response<T> {
    constructor(result: T);
    result: T;
  }
  export class CustomError<T> extends Response<T> {
    constructor(error: Error);
    error: Error
  }
  export class RickAndMortyCharacter {
    constructor(
      id: number,
      name: string,
      status: Status,
      species: string,
      gender: Gender,
      origin: string,
      location: string,
      image: string
    );
    id: number;
    name: string;
    status: Status;
    species: string;
    gender: Gender;
    origin: string;
    location: string;
    image: string;

    from(character: RickAndMortyCharacterREST): RickAndMortyCharacter;
  }

  export class Gender {
    constructor(value: String);
    safeValueOf(value: String): Gender;
  }

  export class Status {
    constructor(value: String);
    safeValueOf(value: String): Status;
  }

  export class RickAndMortyCharacterREST {}
}
