package com.kontvip.myapplication.data

import com.kontvip.myapplication.data.cache.model.CacheMealList
import com.kontvip.myapplication.data.cache.model.CacheRecipeList
import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipeList


interface FetchData<T, D> {
    suspend fun fetchCache(): T
    suspend fun fetchCloud(): D
    suspend fun saveCache(c: T)

    interface MealList : FetchData<CacheMealList, CloudMealList>
    interface RecipeList : FetchData<CacheRecipeList, CloudRecipeList>
}

