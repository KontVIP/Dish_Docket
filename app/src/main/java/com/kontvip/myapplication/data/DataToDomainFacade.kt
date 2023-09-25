package com.kontvip.myapplication.data

import com.kontvip.myapplication.data.cache.model.meal.CacheMeal
import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipe
import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipeList
import com.kontvip.myapplication.domain.model.DomainMeal
import com.kontvip.myapplication.domain.model.DomainRecipe

interface DataToDomainFacade {

    suspend fun processDataToDomainMealList(fetchMealList: HandleData.MealList): List<DomainMeal>
    suspend fun processDataToDomainRecipeList(fetchRecipeList: HandleData.RecipeList): List<DomainRecipe>

    class Default(
        private val cloudMealListToCacheMapper: CloudMealList.Mapper<List<CacheMeal>>,
        private val cloudRecipeListToCacheMapper: CloudRecipeList.Mapper<List<CacheRecipe>>,
        private val cacheMealToDomainMapper: CacheMeal.Mapper<DomainMeal>,
        private val cacheRecipeToDomainMapper: CacheRecipe.Mapper<DomainRecipe>,
    ) : DataToDomainFacade {

        override suspend fun processDataToDomainMealList(fetchMealList: HandleData.MealList): List<DomainMeal> {
            val cacheRecipeList = fetchMealList.fetchCache()
            return if (cacheRecipeList.isEmpty()) {
                val cloudRecipeList = fetchMealList.fetchCloud()
                val cloudRecipeListAsCache = cloudRecipeList.map(cloudMealListToCacheMapper)
                fetchMealList.saveCache(cloudRecipeListAsCache)
                cloudRecipeListAsCache.map { it.map(cacheMealToDomainMapper) }
            } else {
                cacheRecipeList.map { it.map(cacheMealToDomainMapper) }
            }
        }

        override suspend fun processDataToDomainRecipeList(fetchRecipeList: HandleData.RecipeList): List<DomainRecipe> {
            val cacheRecipeList = fetchRecipeList.fetchCache()
            return if (cacheRecipeList.isEmpty()) {
                val cloudRecipeList = fetchRecipeList.fetchCloud()
                val cloudRecipeListAsCache = cloudRecipeList.map(cloudRecipeListToCacheMapper)
                fetchRecipeList.saveCache(cloudRecipeListAsCache)
                cloudRecipeListAsCache.map { it.map(cacheRecipeToDomainMapper) }
            } else {
                cacheRecipeList.map { it.map(cacheRecipeToDomainMapper) }
            }
        }

    }
}
