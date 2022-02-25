import { useCallback, useEffect, useMemo, useRef, useState } from "react";
import { viewmodels, service, models } from "rickandmorty";
import "./App.css";
import Character from "./Character";

function App() {
  const [people, setPeople] = useState([]);
  const [firstPageReached, setFirstPageReached] = useState(false);
  const [bottomReached, setBottomReached] = useState(false);

  const listInnerRef = useRef(null);

  const onResult = useCallback(
    (result: service.models.Response<[models.RickAndMortyCharacter]>) => {
      console.log(service.models);
      if (result instanceof service.models.Response.Loading) {
        console.log("Loading");
      } else if (result instanceof service.models.Response.Success) {
        console.log("Success");
        const myResult = people.concat(result.result.array_hd7ov6$_0);
        setPeople(myResult);
      } else if (result instanceof service.models.Response.CustomError) {
        console?.log("Erreur");
      }
    },
    [people]
  );

  const onScroll = () => {
    if (listInnerRef.current) {
      const { scrollTop, scrollHeight, clientHeight } = listInnerRef.current;
      setBottomReached(false);
      if (scrollTop + clientHeight === scrollHeight) {
        setBottomReached(true);
      }
    }
  };

  useEffect(() => {
    const viewModel = new viewmodels.CharactersViewModel(onResult);
    if (!firstPageReached) {
      viewModel.getFirstPage();
      setFirstPageReached(true);
    }
    if (bottomReached) {
      viewModel.getMoreCharacters();
    }
  }, [onResult, bottomReached, firstPageReached]);

  return (
    <div className="flex flex-col align-center justify-center">
      <div className="container mx-auto px-10 justify-center">
        <div
          className="flex flex-wrap"
          onScroll={onScroll}
          ref={listInnerRef}
          style={{ height: "1000px", overflowY: "auto" }}
        >
          {people.map((person, index) => (
            <Character key={index} character={person} />
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;
