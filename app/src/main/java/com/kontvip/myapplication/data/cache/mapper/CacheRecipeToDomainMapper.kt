package com.kontvip.myapplication.data.cache.mapper

import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipe
import com.kontvip.myapplication.domain.model.DomainRecipe

class CacheRecipeToDomainMapper : CacheRecipe.Mapper<DomainRecipe> {
    override fun map(
        dateModified: String, idMeal: String, strArea: String,
        strCategory: String, strCreativeCommonsConfirmed: String,
        strDrinkAlternate: String, strImageSource: String, strInstructions: String,
        strMeal: String, strMealThumb: String, strSource: String, strTags: String,
        strYoutube: String, ingredientsAndMeasures: Map<String, String>
    ): DomainRecipe {
        return DomainRecipe(
            mealName = strMeal,
            area = strArea,
            category = strCategory,
            instructions = strInstructions,
            ingredientsAndMeasures = ingredientsAndMeasures,
            imageUrl = strMealThumb,
            sourceUrl = strSource,
            youtubeUrl = strYoutube
        )
    }
}