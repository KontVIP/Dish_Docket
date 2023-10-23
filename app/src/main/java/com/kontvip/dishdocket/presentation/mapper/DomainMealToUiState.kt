package com.kontvip.dishdocket.presentation.mapper

import com.kontvip.dishdocket.domain.model.DomainMeal
import com.kontvip.dishdocket.domain.model.DomainMealList
import com.kontvip.dishdocket.presentation.model.UiMeal
import com.kontvip.dishdocket.presentation.model.UiState

class DomainMealListToUiStateMapper : DomainMealList.Mapper<UiState> {
    override fun map(domainMeals: List<DomainMeal>): UiState {
        val domainMealMapper = object : DomainMeal.Mapper<UiMeal> {
            override fun map(mealId: String, mealName: String, imageUrl: String): UiMeal {
                return UiMeal(mealId, mealName, imageUrl)
            }
        }
        return UiState.Meals(domainMeals.map { it.map(domainMealMapper) })
    }
}