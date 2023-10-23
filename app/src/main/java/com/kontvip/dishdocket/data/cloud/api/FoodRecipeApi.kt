package com.kontvip.dishdocket.data.cloud.api

import com.kontvip.dishdocket.data.cloud.model.meal.CloudMealList
import com.kontvip.dishdocket.data.cloud.model.recipe.CloudRecipeList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FoodRecipeApi {

    @Headers("Content-Type: application/json")
    @GET("search.php")
    suspend fun mealsByName(@Query("s") name: String): CloudMealList

    @Headers("Content-Type: application/json")
    @GET("filter.php")
    suspend fun mealsByCountry(@Query("a") country: String): CloudMealList

    @Headers("Content-Type: application/json")
    @GET("filter.php")
    suspend fun mealsByIngredient(@Query("i") ingredient: String): CloudMealList

    @Headers("Content-Type: application/json")
    @GET("lookup.php")
    suspend fun recipeById(@Query("i") id: String): CloudRecipeList

    @Headers("Content-Type: application/json")
    @GET("random.php")
    suspend fun randomRecipe(): CloudRecipeList
}