package com.kontvip.myapplication.data.cloud

import com.kontvip.myapplication.core.AppDispatchers
import com.kontvip.myapplication.data.cloud.api.FoodRecipeApi
import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipeList
import kotlinx.coroutines.withContext

interface CloudSource {

    suspend fun mealsByName(name: String): CloudMealList
    suspend fun mealsByCountry(country: String): CloudMealList
    suspend fun mealsByIngredient(ingredient: String): CloudMealList
    suspend fun recipeById(id: String): CloudRecipeList
    suspend fun randomRecipe(): CloudRecipeList

    class Default(
        private val api: FoodRecipeApi,
        private val appDispatchers: AppDispatchers
    ) : CloudSource {

        override suspend fun mealsByName(name: String): CloudMealList =
            withContext(appDispatchers.io()) { api.mealsByName(name) }

        override suspend fun mealsByCountry(country: String): CloudMealList =
            withContext(appDispatchers.io()) { api.mealsByCountry(country) }

        override suspend fun mealsByIngredient(ingredient: String): CloudMealList =
            withContext(appDispatchers.io()) { api.mealsByIngredient(ingredient) }

        override suspend fun recipeById(id: String): CloudRecipeList =
            withContext(appDispatchers.io()) { api.recipeById(id) }

        override suspend fun randomRecipe(): CloudRecipeList =
            withContext(appDispatchers.io()) { api.randomRecipe() }

    }

}