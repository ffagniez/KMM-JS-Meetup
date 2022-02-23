import React, { useCallback, useEffect, useState } from "react";
import { CharactersViewModel, CustomError, Loading, Response, RickAndMortyCharacter, Success } from "rickandmorty";
import "./App.css";

function App() {
  const [people, setPeople] = useState<[RickAndMortyCharacter?]>([]);

  const onResult = useCallback((result: Response<[RickAndMortyCharacter]>) => {
    if(result instanceof Loading){
      console.log("Loading");
    } else if (result instanceof Success){
      console.log("Success");
      setPeople(result.result)
    } else if (result instanceof CustomError){
      console?.log("Erreur")
    }
    
  }, []);

  useEffect(() => {
    const viewmodel = new CharactersViewModel(onResult);
    viewmodel.getFirstPage();
  }, [onResult]);

  return (
    <div>
      {people.map((person) => (
        <p>{person?.name}</p>
      ))}
    </div>
  );
}

export default App;
