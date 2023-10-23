package com.kontvip.myapplication.presentation.mapper

import com.kontvip.myapplication.domain.model.DomainMeal
import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.presentation.model.UiState

class DomainMealListToUiStateMapper : DomainMealList.Mapper<UiState> {
    override fun map(domainMeals: List<DomainMeal>): UiState {
        val domainMealMapper = object : DomainMeal.Mapper<UiState.Meals.Meal> {
            override fun map(mealId: String, mealName: String, imageUrl: String): UiState.Meals.Meal {
                return UiState.Meals.Meal(mealId, mealName, imageUrl)
            }
        }
        return UiState.Meals(domainMeals.map { it.map(domainMealMapper) })
    }
}