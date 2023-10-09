package com.kontvip.myapplication.data

import com.kontvip.myapplication.data.cache.CacheSource
import com.kontvip.myapplication.data.cache.model.meal.CacheMeal
import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipe
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
        val fetchMealList = object : HandleData.MealList(cacheSource) {
            override suspend fun fetchCache(): List<CacheMeal> = cacheSource.mealsByName(name)
            override suspend fun fetchCloud(): CloudMealList = cloudSource.mealsByName(name)
        }
        return dataToDomainFacade.processDataToDomainMealList(fetchMealList)
    }

    override suspend fun mealsByCountry(country: String): DomainMealList {
        val fetchMealList = object : HandleData.MealList(cacheSource) {
            override suspend fun fetchCache(): List<CacheMeal> = cacheSource.mealsByCountry(country)
            override suspend fun fetchCloud(): CloudMealList = cloudSource.mealsByCountry(country)
        }
        return dataToDomainFacade.processDataToDomainMealList(fetchMealList)
    }

    override suspend fun mealsByIngredient(ingredient: String): DomainMealList {
        val fetchMealList = object : HandleData.MealList(cacheSource) {
            override suspend fun fetchCache(): List<CacheMeal> = cacheSource.mealsByIngredient(ingredient)
            override suspend fun fetchCloud(): CloudMealList = cloudSource.mealsByIngredient(ingredient)
        }
        return dataToDomainFacade.processDataToDomainMealList(fetchMealList)
    }

    override suspend fun recipeById(id: String): DomainRecipeList {
        val fetchRecipeList = object : HandleData.RecipeList(cacheSource) {
            override suspend fun fetchCache(): List<CacheRecipe> = listOf(cacheSource.recipeById(id))
            override suspend fun fetchCloud(): CloudRecipeList = cloudSource.recipeById(id)
        }
        return dataToDomainFacade.processDataToDomainRecipeList(fetchRecipeList)
    }

    override suspend fun randomRecipe():DomainRecipeList {
        val fetchRecipeList = object : HandleData.RecipeList(cacheSource) {
            override suspend fun fetchCache(): List<CacheRecipe> = emptyList()
            override suspend fun fetchCloud(): CloudRecipeList = cloudSource.randomRecipe()
        }
        return dataToDomainFacade.processDataToDomainRecipeList(fetchRecipeList)
    }
}
