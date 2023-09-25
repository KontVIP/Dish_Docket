package com.kontvip.myapplication.domain

import com.kontvip.myapplication.domain.model.DomainMeal
import com.kontvip.myapplication.domain.model.DomainRecipe

interface Repository {

    suspend fun mealsByName(name: String): List<DomainMeal>
    suspend fun mealsByCountry(country: String): List<DomainMeal>
    suspend fun mealsByIngredient(ingredient: String): List<DomainMeal>
    suspend fun recipeById(id: String): List<DomainRecipe>
    suspend fun randomRecipe(): List<DomainRecipe>

}