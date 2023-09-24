package com.kontvip.myapplication.data.cache.model.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "recipe_table", primaryKeys = ["idMeal"])
data class CacheRecipe(
    @ColumnInfo(name = "dateModified")
    val dateModified: String,
    @ColumnInfo(name = "strArea")
    val strArea: String,
    @ColumnInfo(name = "idMeal")
    val idMeal: String,
//    @ColumnInfo("")
//    val strCategory: String,
//    @ColumnInfo("")
//    val strCreativeCommonsConfirmed: Any,
//    @ColumnInfo("")
//    val strDrinkAlternate: Any,
//    @ColumnInfo("")
//    val strImageSource: Any,
//    @ColumnInfo("")
//    val strIngredient1: String,
//    @ColumnInfo("")
//    val strIngredient10: String,
//    @ColumnInfo("")
//    val strIngredient11: String,
//    @ColumnInfo("")
//    val strIngredient12: String,
//    @ColumnInfo("")
//    val strIngredient13: String,
//    @ColumnInfo("")
//    val strIngredient14: String,
//    @ColumnInfo("")
//    val strIngredient15: String,
//    @ColumnInfo("")
//    val strIngredient16: String,
//    @ColumnInfo("")
//    val strIngredient17: String,
//    @ColumnInfo("")
//    val strIngredient18: String,
//    @ColumnInfo("")
//    val strIngredient19: String,
//    @ColumnInfo("")
//    val strIngredient2: String,
//    @ColumnInfo("")
//    val strIngredient20: String,
//    @ColumnInfo("")
//    val strIngredient3: String,
//    @ColumnInfo("")
//    val strIngredient4: String,
//    @ColumnInfo("")
//    val strIngredient5: String,
//    @ColumnInfo("")
//    val strIngredient6: String,
//    @ColumnInfo("")
//    val strIngredient7: String,
//    @ColumnInfo("")
//    val strIngredient8: String,
//    @ColumnInfo("")
//    val strIngredient9: String,
//    @ColumnInfo("")
//    val strInstructions: String,
//    @ColumnInfo("")
//    val strMeal: String,
//    @ColumnInfo("")
//    val strMealThumb: String,
//    @ColumnInfo("")
//    val strMeasure1: String,
//    @ColumnInfo("")
//    val strMeasure10: String,
//    @ColumnInfo("")
//    val strMeasure11: String,
//    @ColumnInfo("")
//    val strMeasure12: String,
//    @ColumnInfo("")
//    val strMeasure13: String,
//    @ColumnInfo("")
//    val strMeasure14: String,
//    @ColumnInfo("")
//    val strMeasure15: String,
//    @ColumnInfo("")
//    val strMeasure16: String,
//    @ColumnInfo("")
//    val strMeasure17: String,
//    @ColumnInfo("")
//    val strMeasure18: String,
//    @ColumnInfo("")
//    val strMeasure19: String,
//    @ColumnInfo("")
//    val strMeasure2: String,
//    @ColumnInfo("")
//    val strMeasure20: String,
//    @ColumnInfo("")
//    val strMeasure3: String,
//    @ColumnInfo("")
//    val strMeasure4: String,
//    @ColumnInfo("")
//    val strMeasure5: String,
//    @ColumnInfo("")
//    val strMeasure6: String,
//    @ColumnInfo("")
//    val strMeasure7: String,
//    @ColumnInfo("")
//    val strMeasure8: String,
//    @ColumnInfo("")
//    val strMeasure9: String,
//    @ColumnInfo("")
//    val strSource: String,
//    @ColumnInfo("")
//    val strTags: String,
//    @ColumnInfo("")
//    val strYoutube: String
)