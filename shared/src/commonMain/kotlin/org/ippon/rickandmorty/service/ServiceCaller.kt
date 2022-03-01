package org.ippon.rickandmorty.service

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.ippon.rickandmorty.annotation.Name
import org.ippon.rickandmorty.network.RickAndMortyApi
import kotlin.native.concurrent.SharedImmutable
@SharedImmutable
internal expect val applicationDispatcher: CoroutineDispatcher

@DelicateCoroutinesApi
open class ServiceCaller {

    val service: RickAndMortyService =
        RickAndMortyService(api = RickAndMortyApi())

    @Name("callInCoroutineScope")
    fun callInCoroutineScope(block: suspend () -> Unit) =
        GlobalScope.launch(applicationDispatcher) {
            block()
        }
}