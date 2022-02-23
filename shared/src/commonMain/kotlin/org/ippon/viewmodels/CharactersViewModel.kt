package org.ippon.viewmodels

import org.ippon.annotation.Name
import org.ippon.models.RickAndMortyCharacter
import org.ippon.service.ServiceCaller
import org.ippon.service.models.Response

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
