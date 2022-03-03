declare module "rickandmorty" {
  export class ArrayList<T> {
    array_hd7ov6$_0: [T];
  }

  export namespace viewmodels {
    export class CharactersViewModel {
      onResult: (
        response: service.models.Response<ArrayList<models.RickAndMortyCharacter>>
      ) => void;
      getFirstPage(): void;
      getMoreCharacters(): void;
    }
  }

  export class Platform {
    platform: string;
  }

  export namespace service {
    export namespace models {
      export class Response<T> {}
      export namespace Response {
        export class Loading<T> extends Response<T> {}
        export class Success<T> extends Response<T> {
          constructor(result: T);
          result: T;
        }
        export class CustomError<T> extends Response<T> {
          constructor(error: Error);
          error: Error;
        }
      }
    }
  }

  export namespace models {
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

      from(character: network.RickAndMortyCharacterREST): RickAndMortyCharacter;
    }

    export class Gender {
      constructor(value: String);
      value: String;
      safeValueOf(value: String): Gender;
    }

    export class Status {
      constructor(value: String);
      value: String;
      safeValueOf(value: String): Status;
    }
  }

  export namespace network {
    export class RickAndMortyCharacterREST {}
  }
}
