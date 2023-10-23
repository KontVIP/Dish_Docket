package com.kontvip.dishdocket.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface AppDispatchers {

    fun io(): CoroutineDispatcher
    fun ui(): CoroutineDispatcher

    class Default : AppDispatchers {
        override fun io(): CoroutineDispatcher = Dispatchers.IO
        override fun ui(): CoroutineDispatcher = Dispatchers.Main
    }
}