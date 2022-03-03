import { useCallback, useEffect, useMemo, useRef, useState } from "react";
import { viewmodels, service, models } from "rickandmorty";
import "./App.css";
import Character from "./Character";

function App() {
  const [people, setPeople] = useState([]);
  const loader = useRef(null);
  const viewModel = useMemo<viewmodels.CharactersViewModel>(
    () => new viewmodels.CharactersViewModel(),
    []
  );

  const onResult = useCallback(
    (response: service.models.Response<[models.RickAndMortyCharacter]>) => {
      if (response instanceof service.models.Response.Loading) {
        displayLoading();
      } else if (response instanceof service.models.Response.Success) {
        const myResult = people.concat(response.result.array_hd7ov6$_0);
        setPeople(myResult);
      } else if (response instanceof service.models.Response.CustomError) {
        displayError();
      }
    },
    [people]
  );

  const loadMore = useCallback<IntersectionObserverCallback>(
    (entries) => {
      const target = entries[0];
      if (target.isIntersecting) {
        viewModel.getMoreCharacters();
      }
    },
    [viewModel]
  );

  useEffect(() => {
    var isMount = true;
    const options = {
      root: null,
      rootMargin: "0px",
      threshold: 0.25,
    };

    const observer = new IntersectionObserver(loadMore, options);
    const target = loader.current;
    if (loader && loader.current) {
      observer.observe(loader.current);
    }

    viewModel.onResult = (
      result: service.models.Response<[models.RickAndMortyCharacter]>
    ) => {
      if (!isMount) return;
      onResult(result);
    };

    return () => {
      isMount = false;
      if (target) {
        observer.unobserve(target);
      }
    };
  }, [loadMore, onResult, viewModel]);

  return (
    <div className="flex flex-col align-center justify-center">
      <div className="container mx-auto px-10 justify-center">
        <div className="flex flex-wrap">
          {people.map((person, index) => (
            <Character key={index} character={person} />
          ))}
          <p ref={loader}>Loading...</p>
        </div>
      </div>
    </div>
  );
}

export default App;
function displayError() {
  console.log("Error");
}

function displayLoading() {
  console.log("Loading");
}
