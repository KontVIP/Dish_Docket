package com.kontvip.myapplication.data.cache

import com.kontvip.myapplication.data.cache.model.CacheMealList
import com.kontvip.myapplication.data.cache.model.CacheRecipeList

interface CacheSource {
    suspend fun mealsByName(name: String): CacheMealList
    suspend fun saveMealsByName(name: String, cacheMealList: CacheMealList)

    suspend fun mealsByCountry(country: String): CacheMealList
    suspend fun saveMealsByCountry(country: String, cacheMealList: CacheMealList)

    suspend fun mealsByIngredient(ingredient: String): CacheMealList
    suspend fun saveMealsByIngredient(ingredient: String, cacheMealList: CacheMealList)

    suspend fun recipeById(id: Int): CacheRecipeList
    suspend fun saveRecipeById(id: Int, cacheRecipeList: CacheRecipeList)

    suspend fun randomRecipe(): CacheRecipeList


    class Default : CacheSource {
        override suspend fun mealsByName(name: String): CacheMealList {
            TODO("Not yet implemented")
        }

        override suspend fun saveMealsByName(name: String, cacheMealList: CacheMealList) {
            TODO("Not yet implemented")
        }

        override suspend fun mealsByCountry(country: String): CacheMealList {
            TODO("Not yet implemented")
        }

        override suspend fun saveMealsByCountry(country: String, cacheMealList: CacheMealList) {
            TODO("Not yet implemented")
        }

        override suspend fun mealsByIngredient(ingredient: String): CacheMealList {
            TODO("Not yet implemented")
        }

        override suspend fun saveMealsByIngredient(
            ingredient: String,
            cacheMealList: CacheMealList
        ) {
            TODO("Not yet implemented")
        }

        override suspend fun recipeById(id: Int): CacheRecipeList {
            TODO("Not yet implemented")
        }

        override suspend fun saveRecipeById(id: Int, cacheRecipeList: CacheRecipeList) {
            TODO("Not yet implemented")
        }

        override suspend fun randomRecipe(): CacheRecipeList {
            TODO("Not yet implemented")
        }

    }

}