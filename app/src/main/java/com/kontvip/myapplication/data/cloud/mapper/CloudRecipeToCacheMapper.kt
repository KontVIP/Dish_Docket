package com.kontvip.myapplication.data.cloud.mapper

import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipe
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipe

class CloudRecipeToCacheMapper : CloudRecipe.Mapper<CacheRecipe> {

    override fun map(
        dateModified: String, idMeal: String, strArea: String,
        strCategory: String, strCreativeCommonsConfirmed: String,
        strDrinkAlternate: String, strImageSource: String,
        strInstructions: String, strMeal: String,
        strMealThumb: String, strSource: String,
        strTags: String, strYoutube: String,
        ingredientsAndMeasures: Map<String, String>
    ): CacheRecipe {
        return CacheRecipe(
            dateModified, idMeal, strArea, strCategory, strCreativeCommonsConfirmed,
            strDrinkAlternate, strImageSource, strInstructions, strMeal,
            strMealThumb, strSource, strTags, strYoutube, ingredientsAndMeasures
        )
    }
}