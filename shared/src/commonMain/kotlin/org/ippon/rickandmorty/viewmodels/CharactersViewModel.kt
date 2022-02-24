package org.ippon.rickandmorty.viewmodels

import org.ippon.rickandmorty.annotation.Name
import org.ippon.rickandmorty.models.RickAndMortyCharacter
import org.ippon.rickandmorty.service.ServiceCaller
import org.ippon.rickandmorty.service.models.Response
import kotlin.js.JsExport

@JsExport
class CharactersViewModel(val getResult: (result: Response<List<RickAndMortyCharacter>>) -> Unit) :
    ServiceCaller() {
    var currentPage = 1

    init {
        getResult(Response.Loading())
    }

    @Name("getFirstPage")
    fun getFirstPage() {
        currentPage = 1
        getMoreCharacters()
    }

    @Name("getMoreCharacters")
    fun getMoreCharacters() = callInCoroutineScope {
        getResult(Response.Loading())
        getResult(service.getCharacters(currentPage))
        currentPage += 1
    }
}
