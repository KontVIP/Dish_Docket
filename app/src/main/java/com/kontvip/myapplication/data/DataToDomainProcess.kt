package com.kontvip.myapplication.data

import com.kontvip.myapplication.data.cache.model.CacheMealList
import com.kontvip.myapplication.data.cache.model.CacheRecipeList
import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipeList
import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.domain.model.DomainRecipeList

interface DataToDomainProcess {

    suspend fun processDataToDomainMealList(fetchMealList: FetchData.MealList): DomainMealList
    suspend fun processDataToDomainRecipeList(fetchRecipeList: FetchData.RecipeList): DomainRecipeList

    class Default(
        private val cloudMealListToCacheMapper: CloudMealList.Mapper<CacheMealList>,
        private val cacheMealListToDomainMapper: CacheMealList.Mapper<DomainMealList>,
        private val cloudRecipeListToCacheMapper: CloudRecipeList.Mapper<CacheRecipeList>,
        private val cacheRecipeListToDomainMapper: CacheRecipeList.Mapper<DomainRecipeList>,
    ) : DataToDomainProcess {

        override suspend fun processDataToDomainMealList(fetchMealList: FetchData.MealList): DomainMealList {
            val cacheRecipeList = fetchMealList.fetchCache()
            return if (cacheRecipeList.isEmpty()) {
                val cloudRecipeList = fetchMealList.fetchCloud()
                val cloudRecipeListAsCache = cloudRecipeList.map(cloudMealListToCacheMapper)
                fetchMealList.saveCache(cloudRecipeListAsCache)
                cloudRecipeListAsCache.map(cacheMealListToDomainMapper)
            } else {
                cacheRecipeList.map(cacheMealListToDomainMapper)
            }
        }

        override suspend fun processDataToDomainRecipeList(fetchRecipeList: FetchData.RecipeList): DomainRecipeList {
            val cacheRecipeList = fetchRecipeList.fetchCache()
            return if (cacheRecipeList.isEmpty()) {
                val cloudRecipeList = fetchRecipeList.fetchCloud()
                val cloudRecipeListAsCache = cloudRecipeList.map(cloudRecipeListToCacheMapper)
                fetchRecipeList.saveCache(cloudRecipeListAsCache)
                cloudRecipeListAsCache.map(cacheRecipeListToDomainMapper)
            } else {
                cacheRecipeList.map(cacheRecipeListToDomainMapper)
            }
        }

    }
}
