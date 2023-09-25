package com.kontvip.myapplication.presentation.model

abstract class UiState {

    data class Success(
        private val mealId: String,
        private val mealName: String,
        private val imageUrl: String
    ) : UiState()
}