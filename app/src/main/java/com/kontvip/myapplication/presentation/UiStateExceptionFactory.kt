package com.kontvip.myapplication.presentation

import com.kontvip.myapplication.domain.core.StateExceptionFactory
import com.kontvip.myapplication.presentation.model.UiState
import java.net.UnknownHostException

class UiStateExceptionFactory : StateExceptionFactory {
    override fun build(e: Exception): UiState = when (e) {
        is SecurityException -> UiState.NoPermissions()
        is UnknownHostException -> UiState.NoInternet()
        else -> UiState.ServiceUnavailable()
    }
}