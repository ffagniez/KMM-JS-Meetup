import { FC } from "react";
import { models } from "rickandmorty";

interface CharacterProps {
  character: models.RickAndMortyCharacter | undefined;
}

const Character: FC<CharacterProps> = ({ character }) => {

  return (
    <button className="w-1/5 mr-1 mb-1 overflow-hidden relative cursor-pointer">
      <img className="object-contain" src={character?.image} alt="avatar"/>
      <h3 className="absolute bottom-0 text-center w-full bg-green-700 text-xs px-2 py-1">
        {character?.name}
      </h3>
      <h3 className="absolute bottom-0 text-center w-full bg-green-700 text-xs px-2 py-1">
        {character?.species} - {character?.status?.value}
      </h3>
    </button>
  );
};


export default Character;
