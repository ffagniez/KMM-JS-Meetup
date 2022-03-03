package org.ippon.rickandmorty.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.ippon.rickandmorty.models.RickAndMortyCharacter
import org.ippon.rickandmorty.service.models.Response
import org.ippon.rickandmorty.viewmodels.CharactersViewModel

class MyCharactersViewModel : ViewModel() {

    val characters: LiveData<Response<List<RickAndMortyCharacter>>>
        get() {
            return _characters
        }
    private val _characters = MutableLiveData<Response<List<RickAndMortyCharacter>>>()
    private val charactersViewModel: CharactersViewModel = CharactersViewModel()
    private val onResult = fun(response: Response<List<RickAndMortyCharacter>>) {
       displaySuccess(response)
    }

    init {
        charactersViewModel.onResult = onResult
    }

    private fun displaySuccess(response: Response<List<RickAndMortyCharacter>>) {
        _characters.postValue(response)
    }

    fun getFirstPage() {
        charactersViewModel.getFirstPage()
    }

    fun getMoreCharacters() {
        charactersViewModel.getMoreCharacters()
    }

}


