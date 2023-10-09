package com.kontvip.myapplication.domain.mapper

import com.kontvip.myapplication.domain.model.DishDocketResult

interface ExceptionFactory {

    fun build(e: Exception): DishDocketResult

}