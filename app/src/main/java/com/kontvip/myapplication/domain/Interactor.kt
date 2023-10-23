package com.kontvip.myapplication.domain

import com.kontvip.myapplication.domain.core.StateExceptionFactory
import com.kontvip.myapplication.domain.model.DishDocketState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

abstract class Interactor(private val stateExceptionFactory: StateExceptionFactory) {

    protected suspend fun invoke(block: suspend () -> DishDocketState): Flow<DishDocketState> =
        try {
            flowOf(block.invoke())
        } catch (e: Exception) {
            flowOf(stateExceptionFactory.build(e))
        }
}