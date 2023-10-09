package com.kontvip.myapplication.presentation

import com.kontvip.myapplication.domain.mapper.StateExceptionFactory
import com.kontvip.myapplication.domain.model.DishDocketState
import com.kontvip.myapplication.presentation.model.NoInternetUiState
import com.kontvip.myapplication.presentation.model.NoPermissionsUiState
import com.kontvip.myapplication.presentation.model.ServiceUnavailableUiState
import java.net.UnknownHostException

class UiStateExceptionFactory : StateExceptionFactory {
    override fun build(e: Exception): DishDocketState = when (e) {
        is SecurityException -> NoPermissionsUiState()
        is UnknownHostException -> NoInternetUiState()
        else -> ServiceUnavailableUiState()
    }
}