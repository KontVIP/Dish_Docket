package com.kontvip.dishdocket.domain.core

import com.kontvip.dishdocket.domain.model.DishDocketState

interface StateExceptionFactory {

    fun build(e: Exception): DishDocketState

}