package com.kontvip.dishdocket.data.cache

import com.kontvip.dishdocket.data.cache.database.DishDocketDao
import com.kontvip.dishdocket.data.cache.model.meal.CacheMeal
import com.kontvip.dishdocket.data.cache.model.recipe.CacheRecipe

interface CacheSource {
    suspend fun mealsByName(name: String): List<CacheMeal>
    suspend fun mealsByCountry(country: String): List<CacheMeal>
    suspend fun mealsByIngredient(ingredient: String): List<CacheMeal>
    suspend fun saveMealList(cacheMealList: List<CacheMeal>)

    suspend fun recipeById(id: String): CacheRecipe
    suspend fun saveRecipeList(cacheRecipeList: List<CacheRecipe>)

    class Default(private val dao: DishDocketDao) : CacheSource {
        override suspend fun mealsByName(name: String): List<CacheMeal> {
            return dao.cacheMealsByName(name)
        }

        override suspend fun mealsByCountry(country: String): List<CacheMeal> {
            return dao.cacheMealsByCountry(area = country)
        }

        override suspend fun mealsByIngredient(ingredient: String): List<CacheMeal> {
            return dao.cacheMealsByIngredient(ingredient)
        }

        override suspend fun saveMealList(cacheMealList: List<CacheMeal>) {
            cacheMealList.forEach {
                dao.insertCacheMeal(it)
            }
        }

        override suspend fun recipeById(id: String): CacheRecipe {
            return dao.cacheRecipeById(id)
        }

        override suspend fun saveRecipeList(cacheRecipeList: List<CacheRecipe>) {
           cacheRecipeList.forEach {
               dao.insertCacheRecipe(it)
           }
        }
    }

}