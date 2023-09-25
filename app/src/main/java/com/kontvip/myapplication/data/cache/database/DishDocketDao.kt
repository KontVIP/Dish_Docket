package com.kontvip.myapplication.data.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kontvip.myapplication.data.cache.model.meal.CacheMeal
import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipe

@Dao
interface DishDocketDao {

    @Query("SELECT * FROM meal_table WHERE strMeal LIKE '%' || :name || '%'")
    fun cacheMealsByName(name: String): List<CacheMeal>

    @Query(
        "SELECT DISTINCT meal_table.* " +
                "FROM meal_table INNER JOIN recipe_table " +
                "ON meal_table.idMeal = recipe_table.idMeal " +
                "WHERE recipe_table.strArea = :area"
    )
    fun cacheMealsByCountry(area: String): List<CacheMeal>

    @Query(
        "SELECT DISTINCT meal_table.* " +
                "FROM meal_table " +
                "INNER JOIN recipe_table " +
                "ON meal_table.idMeal = recipe_table.idMeal " +
                "WHERE meal_table.idMeal IN " +
                "(SELECT recipe_table.idMeal FROM recipe_table " +
                "WHERE ingredientsAndMeasures LIKE '%' || :ingredient || '%')"
    )
    fun cacheMealsByIngredient(ingredient: String): List<CacheMeal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCacheMeal(cacheMeal: CacheMeal)

    @Query("SELECT * FROM recipe_table WHERE idMeal = :id")
    fun cacheRecipeById(id: String): CacheRecipe

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCacheRecipe(cacheRecipe: CacheRecipe)

}