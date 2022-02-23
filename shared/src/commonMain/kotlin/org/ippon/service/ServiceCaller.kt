package org.ippon.service

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.ippon.annotation.Name
import org.ippon.database.Repository
import org.ippon.network.RickAndMortyApi
import kotlin.native.concurrent.SharedImmutable
@SharedImmutable
internal expect val applicationDispatcher: CoroutineDispatcher

@DelicateCoroutinesApi
open class ServiceCaller {

    val service: RickAndMortyService =
        RickAndMortyService(api = RickAndMortyApi(), repository = Repository())


    @Name("callInCoroutineScope")
    fun callInCoroutineScope(block: suspend () -> Unit) =
        GlobalScope.launch(applicationDispatcher) {
            block()
        }
}