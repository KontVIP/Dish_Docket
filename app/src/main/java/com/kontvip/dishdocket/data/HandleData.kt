package com.kontvip.dishdocket.data

import com.kontvip.dishdocket.data.cache.CacheSource
import com.kontvip.dishdocket.data.cache.model.meal.CacheMeal
import com.kontvip.dishdocket.data.cache.model.recipe.CacheRecipe
import com.kontvip.dishdocket.data.cloud.model.meal.CloudMealList
import com.kontvip.dishdocket.data.cloud.model.recipe.CloudRecipeList


interface HandleData<T, D> {
    suspend fun fetchCache(): T
    suspend fun fetchCloud(): D
    suspend fun saveCache(c: T)

    abstract class MealList(
        private val cacheSource: CacheSource
    ) : HandleData<List<CacheMeal>, CloudMealList> {
        override suspend fun saveCache(c: List<CacheMeal>): Unit = cacheSource.saveMealList(c)
    }

    abstract class RecipeList(
        private val cacheSource: CacheSource
    ) : HandleData<List<CacheRecipe>, CloudRecipeList> {
        override suspend fun saveCache(c: List<CacheRecipe>): Unit = cacheSource.saveRecipeList(c)
    }
}

