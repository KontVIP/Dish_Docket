package com.kontvip.myapplication.presentation.mapper

import com.kontvip.myapplication.domain.model.DishDocketState
import com.kontvip.myapplication.domain.model.DomainMeal
import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.presentation.model.MealUiState

class DomainMealListToUiState : DomainMealList.Mapper<DishDocketState> {
    override fun map(domainMeals: List<DomainMeal>): DishDocketState {
        val domainMealMapper = object : DomainMeal.Mapper<MealUiState> {
            override fun map(mealId: String, mealName: String, imageUrl: String): MealUiState {
                return MealUiState()
            }
        }
        return domainMeals.map { it.map(domainMealMapper) }
    }
}