package org.ippon.rickandmorty.service

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val applicationDispatcher: CoroutineDispatcher = Dispatchers.IO