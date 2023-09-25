package com.kontvip.myapplication.presentation.mapper

import com.kontvip.myapplication.domain.model.DomainMeal
import com.kontvip.myapplication.presentation.model.UiState

class DomainMealToUiState : DomainMeal.Mapper<UiState> {
    override fun map(mealId: String, mealName: String, imageUrl: String): UiState {
        return UiState.Success(mealId, mealName, imageUrl)
    }
}