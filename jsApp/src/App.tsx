import { useCallback, useEffect, useState } from "react";
import { viewmodels, service, models } from "rickandmorty";
import "./App.css";

function App() {
  const [people, setPeople] = useState<[models.RickAndMortyCharacter?]>([]);

  const onResult = useCallback((result: service.models.Response<[models.RickAndMortyCharacter]>) => {
    console.log(service.models);
    if(result instanceof service.models.Response.Loading){
      console.log("Loading");
    } else if (result instanceof service.models.Response.Success){
      console.log("Success");
      setPeople(result.result.array_hd7ov6$_0)
    } else if (result instanceof service.models.Response.CustomError){
      console?.log("Erreur")
    }

  }, []);

  useEffect(() => {
    const viewmodel = new viewmodels.CharactersViewModel(onResult);
    viewmodel.getFirstPage();
  }, [onResult]);


  return (
    <div>
      {people.map((person) => (
        <p>{person?.name}</p>
      ))}
      {/* <p>{`Coucou ${new Platform().platform}`}</p> */}
    </div>
  );
}

export default App;
