package org.ippon.rickandmorty.android.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.ippon.models.RickAndMortyCharacter
import org.ippon.rickandmorty.android.databinding.FragmentCharacterBinding

class CharactersRecyclerViewAdapter(
    private var values: List<RickAndMortyCharacter>
) : RecyclerView.Adapter<CharactersRecyclerViewAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentCharacterBinding.inflate(layoutInflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    fun addItems(values: List<RickAndMortyCharacter>) {
        this.values += values
        notifyDataSetChanged()
    }

    fun setItems(values: List<RickAndMortyCharacter>) {
        this.values = values
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(private val binding: FragmentCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: RickAndMortyCharacter) {
            with(binding) {
                Glide.with(itemView)
                    .load(character.image)
                    .circleCrop()
                    .into(characterImage)

                characterName.text = character.name
                characterSpeciesAndStatus.text = "${character.status} - ${character.species}"
            }
        }
    }
}

