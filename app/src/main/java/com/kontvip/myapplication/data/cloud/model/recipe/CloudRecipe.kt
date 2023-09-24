package com.kontvip.myapplication.data.cloud.model.recipe

data class CloudRecipe(
    val dateModified: String,
    val idMeal: String,
    val strArea: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrinkAlternate: String,
    val strImageSource: String,
    val strInstructions: String,
    val strMeal: String,
    val strMealThumb: String,
    val strSource: String,
    val strTags: String,
    val strYoutube: String,
    val ingredients: List<String>,
    val measures: List<String>
)