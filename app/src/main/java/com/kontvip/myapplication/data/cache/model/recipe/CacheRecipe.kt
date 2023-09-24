package com.kontvip.myapplication.data.cache.model.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "recipe_table", primaryKeys = ["idMeal"])
data class CacheRecipe(
    @ColumnInfo(name = "dateModified")
    val dateModified: String,
    @ColumnInfo(name = "idMeal")
    val idMeal: String,
    @ColumnInfo(name = "strArea")
    val strArea: String,
    @ColumnInfo(name = "strCategory")
    val strCategory: String,
    @ColumnInfo(name = "strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String,
    @ColumnInfo(name = "strDrinkAlternate")
    val strDrinkAlternate: String,
    @ColumnInfo(name = "strImageSource")
    val strImageSource: String,
    @ColumnInfo(name = "strInstructions")
    val strInstructions: String,
    @ColumnInfo(name = "strMeal")
    val strMeal: String,
    @ColumnInfo(name = "strMealThumb")
    val strMealThumb: String,
    @ColumnInfo(name = "strSource")
    val strSource: String,
    @ColumnInfo(name = "strTags")
    val strTags: String,
    @ColumnInfo(name = "strYoutube")
    val strYoutube: String,
    @ColumnInfo(name = "ingredients")
    val ingredients: List<String>,
    @ColumnInfo(name = "measures")
    val measures: List<String>
)