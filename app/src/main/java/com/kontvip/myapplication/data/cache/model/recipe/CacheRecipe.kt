package com.kontvip.myapplication.data.cache.model.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class CacheRecipe(
    @ColumnInfo(name = "dateModified") val dateModified: String,
    @ColumnInfo(name = "idMeal") @PrimaryKey val idMeal: String,
    @ColumnInfo(name = "strArea") val strArea: String,
    @ColumnInfo(name = "strCategory") val strCategory: String,
    @ColumnInfo(name = "strCreativeCommonsConfirmed") val strCreativeCommonsConfirmed: String,
    @ColumnInfo(name = "strDrinkAlternate") val strDrinkAlternate: String,
    @ColumnInfo(name = "strImageSource") val strImageSource: String,
    @ColumnInfo(name = "strInstructions") val strInstructions: String,
    @ColumnInfo(name = "strMeal") val strMeal: String,
    @ColumnInfo(name = "strMealThumb") val strMealThumb: String,
    @ColumnInfo(name = "strSource") val strSource: String,
    @ColumnInfo(name = "strTags") val strTags: String,
    @ColumnInfo(name = "strYoutube") val strYoutube: String,
    @ColumnInfo(name = "ingredientsAndMeasures") val ingredientsAndMeasures: Map<String, String>
) {

    interface Mapper<T> {
        fun map(
            dateModified: String, idMeal: String, strArea: String,
            strCategory: String, strCreativeCommonsConfirmed: String,
            strDrinkAlternate: String, strImageSource: String,
            strInstructions: String, strMeal: String, strMealThumb: String,
            strSource: String, strTags: String, strYoutube: String,
            ingredientsAndMeasures: Map<String, String>
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        dateModified, idMeal, strArea,
        strCategory, strCreativeCommonsConfirmed,
        strDrinkAlternate, strImageSource,
        strInstructions, strMeal, strMealThumb,
        strSource, strTags, strYoutube,
        ingredientsAndMeasures
    )
}