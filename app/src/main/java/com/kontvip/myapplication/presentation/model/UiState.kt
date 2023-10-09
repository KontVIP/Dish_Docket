package com.kontvip.myapplication.presentation.model

abstract class UiState {

    abstract fun display()

    data class Success(
        private val mealId: String,
        private val mealName: String,
        private val imageUrl: String
    ) : UiState() {
        override fun display() {
            TODO("Not yet implemented")
        }
    }

    data class Fail(private val uiException: UiException): UiState() {
        override fun display() {
            TODO("Not yet implemented")
        }
    }

}