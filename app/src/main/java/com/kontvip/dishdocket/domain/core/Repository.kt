package com.kontvip.dishdocket.domain.core

import com.kontvip.dishdocket.domain.model.DomainMealList
import com.kontvip.dishdocket.domain.model.DomainRecipeList

interface Repository {

    suspend fun mealsByName(name: String): DomainMealList
    suspend fun mealsByCountry(country: String): DomainMealList
    suspend fun mealsByIngredient(ingredient: String): DomainMealList
    suspend fun recipeById(id: String): DomainRecipeList
    suspend fun randomRecipe(): DomainRecipeList

}