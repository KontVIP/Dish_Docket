package com.kontvip.dishdocket.data

import com.kontvip.dishdocket.data.cache.CacheSource
import com.kontvip.dishdocket.data.cache.model.meal.CacheMeal
import com.kontvip.dishdocket.data.cache.model.recipe.CacheRecipe
import com.kontvip.dishdocket.data.cloud.CloudSource
import com.kontvip.dishdocket.data.cloud.model.meal.CloudMealList
import com.kontvip.dishdocket.data.cloud.model.recipe.CloudRecipeList
import com.kontvip.dishdocket.domain.core.Repository
import com.kontvip.dishdocket.domain.model.DomainMealList
import com.kontvip.dishdocket.domain.model.DomainRecipeList

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
