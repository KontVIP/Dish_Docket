package com.kontvip.myapplication.data

import com.kontvip.myapplication.data.cache.model.meal.CacheMeal
import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipe
import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipeList
import com.kontvip.myapplication.domain.model.DomainMeal
import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.domain.model.DomainRecipe
import com.kontvip.myapplication.domain.model.DomainRecipeList

interface DataToDomainFacade {

    suspend fun processDataToDomainMealList(fetchMealList: HandleData.MealList): DomainMealList
    suspend fun processDataToDomainRecipeList(fetchRecipeList: HandleData.RecipeList): DomainRecipeList

    class Default(
        private val cloudMealListToCacheMapper: CloudMealList.Mapper<List<CacheMeal>>,
        private val cloudRecipeListToCacheMapper: CloudRecipeList.Mapper<List<CacheRecipe>>,
        private val cacheMealToDomainMapper: CacheMeal.Mapper<DomainMeal>,
        private val cacheRecipeToDomainMapper: CacheRecipe.Mapper<DomainRecipe>,
    ) : DataToDomainFacade {

        override suspend fun processDataToDomainMealList(fetchMealList: HandleData.MealList): DomainMealList {
            val cacheRecipeList = fetchMealList.fetchCache()
            return if (cacheRecipeList.isEmpty()) {
                val cloudRecipeList = fetchMealList.fetchCloud()
                val cloudRecipeListAsCache = cloudRecipeList.map(cloudMealListToCacheMapper)
                fetchMealList.saveCache(cloudRecipeListAsCache)
                DomainMealList(cloudRecipeListAsCache.map { it.map(cacheMealToDomainMapper) })
            } else {
                DomainMealList(cacheRecipeList.map { it.map(cacheMealToDomainMapper) })
            }
        }

        override suspend fun processDataToDomainRecipeList(fetchRecipeList: HandleData.RecipeList): DomainRecipeList {
            val cacheRecipeList = fetchRecipeList.fetchCache()
            return if (cacheRecipeList.isEmpty()) {
                val cloudRecipeList = fetchRecipeList.fetchCloud()
                val cloudRecipeListAsCache = cloudRecipeList.map(cloudRecipeListToCacheMapper)
                fetchRecipeList.saveCache(cloudRecipeListAsCache)
                DomainRecipeList(cloudRecipeListAsCache.map { it.map(cacheRecipeToDomainMapper) })
            } else {
                DomainRecipeList(cacheRecipeList.map { it.map(cacheRecipeToDomainMapper) })
            }
        }
    }
}
