package com.kontvip.dishdocket.presentation

import com.kontvip.dishdocket.domain.core.StateExceptionFactory
import com.kontvip.dishdocket.presentation.model.UiState
import java.net.UnknownHostException

class UiStateExceptionFactory : StateExceptionFactory {
    override fun build(e: Exception): UiState = when (e) {
        is SecurityException -> UiState.NoPermissions()
        is UnknownHostException -> UiState.NoInternet()
        else -> UiState.ServiceUnavailable()
    }
}