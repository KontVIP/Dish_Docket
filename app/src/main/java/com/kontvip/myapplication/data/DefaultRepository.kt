package com.kontvip.myapplication.data

import com.kontvip.myapplication.data.cache.CacheSource
import com.kontvip.myapplication.data.cache.model.meal.CacheMealList
import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipeList
import com.kontvip.myapplication.data.cloud.CloudSource
import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipeList
import com.kontvip.myapplication.domain.Repository
import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.domain.model.DomainRecipeList

class DefaultRepository(
    private val cloudSource: CloudSource,
    private val cacheSource: CacheSource,
    private val dataToDomainFacade: DataToDomainFacade
) : Repository {

    override suspend fun mealsByName(name: String): DomainMealList {
        val fetchMealList = object : FetchData.MealList {
            override suspend fun fetchCache(): CacheMealList = cacheSource.mealsByName(name)
            override suspend fun fetchCloud(): CloudMealList = cloudSource.mealsByName(name)
            override suspend fun saveCache(c: CacheMealList) = cacheSource.saveMealsByName(name, c)
        }
        return dataToDomainFacade.processDataToDomainMealList(fetchMealList)
    }

    override suspend fun mealsByCountry(country: String): DomainMealList {
        val fetchMealList = object : FetchData.MealList {
            override suspend fun fetchCache(): CacheMealList = cacheSource.mealsByCountry(country)
            override suspend fun fetchCloud(): CloudMealList = cloudSource.mealsByCountry(country)
            override suspend fun saveCache(c: CacheMealList) = cacheSource.saveMealsByCountry(country, c)
        }
        return dataToDomainFacade.processDataToDomainMealList(fetchMealList)
    }

    override suspend fun mealsByIngredient(ingredient: String): DomainMealList {
        val fetchMealList = object : FetchData.MealList {
            override suspend fun fetchCache(): CacheMealList = cacheSource.mealsByIngredient(ingredient)
            override suspend fun fetchCloud(): CloudMealList = cloudSource.mealsByIngredient(ingredient)
            override suspend fun saveCache(c: CacheMealList) = cacheSource.saveMealsByIngredient(ingredient, c)
        }
        return dataToDomainFacade.processDataToDomainMealList(fetchMealList)
    }

    override suspend fun recipeById(id: Int): DomainRecipeList {
        val fetchRecipeList = object : FetchData.RecipeList {
            override suspend fun fetchCache(): CacheRecipeList = cacheSource.recipeById(id)
            override suspend fun fetchCloud(): CloudRecipeList = cloudSource.recipeById(id)
            override suspend fun saveCache(c: CacheRecipeList) = cacheSource.saveRecipeById(id, c)
        }
        return dataToDomainFacade.processDataToDomainRecipeList(fetchRecipeList)
    }

    override suspend fun randomRecipe(): DomainRecipeList {
        val fetchRecipeList = object : FetchData.RecipeList {
            override suspend fun fetchCache(): CacheRecipeList = CacheRecipeList.Empty()
            override suspend fun fetchCloud(): CloudRecipeList = cloudSource.randomRecipe()
            override suspend fun saveCache(c: CacheRecipeList) = Unit
        }
        return dataToDomainFacade.processDataToDomainRecipeList(fetchRecipeList)
    }
}
