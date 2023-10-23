package com.kontvip.myapplication.domain.core

import com.kontvip.myapplication.domain.model.DishDocketState

interface StateExceptionFactory {

    fun build(e: Exception): DishDocketState

}