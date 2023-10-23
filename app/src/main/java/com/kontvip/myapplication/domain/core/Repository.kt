package com.kontvip.myapplication.domain.core

import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.domain.model.DomainRecipeList

interface Repository {

    suspend fun mealsByName(name: String): DomainMealList
    suspend fun mealsByCountry(country: String): DomainMealList
    suspend fun mealsByIngredient(ingredient: String): DomainMealList
    suspend fun recipeById(id: String): DomainRecipeList
    suspend fun randomRecipe(): DomainRecipeList

}