package org.ippon.rickandmorty.viewmodels

import org.ippon.rickandmorty.annotation.Name
import org.ippon.rickandmorty.models.RickAndMortyCharacter
import org.ippon.rickandmorty.service.ServiceCaller
import org.ippon.rickandmorty.service.models.Response
import kotlin.js.JsExport

@JsExport
open class CharactersViewModel : ServiceCaller() {
    var currentPage = 1
    var onResult: ((Response<List<RickAndMortyCharacter>>) -> Unit)? = null

    @Name("getFirstPage")
    fun getFirstPage() {
        currentPage = 1
        getMoreCharacters()
    }

    @Name("getMoreCharacters")
    fun getMoreCharacters() = callInCoroutineScope {
        onResult?.invoke(Response.Loading())
        onResult?.invoke(service.getCharacters(currentPage))
        currentPage += 1
    }
}
