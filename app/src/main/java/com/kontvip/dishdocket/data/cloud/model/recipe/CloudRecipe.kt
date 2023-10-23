package com.kontvip.dishdocket.data.cloud.model.recipe

data class CloudRecipe(
    private val dateModified: String,
    private val idMeal: String,
    private val strArea: String,
    private val strCategory: String,
    private val strCreativeCommonsConfirmed: String,
    private val strDrinkAlternate: String,
    private val strImageSource: String,
    private val strInstructions: String,
    private val strMeal: String,
    private val strMealThumb: String,
    private val strSource: String,
    private val strTags: String,
    private val strYoutube: String,
    private val ingredientsAndMeasures: Map<String, String>
) {

    interface Mapper<T> {
        fun map(
            dateModified: String, idMeal: String, strArea: String,
            strCategory: String, strCreativeCommonsConfirmed: String,
            strDrinkAlternate: String, strImageSource: String,
            strInstructions: String, strMeal: String,
            strMealThumb: String, strSource: String,
            strTags: String, strYoutube: String,
            ingredientsAndMeasures: Map<String, String>
        ): T
    }

    fun <T> map(mapper: Mapper<T>) = mapper.map(
        dateModified, idMeal, strArea, strCategory, strCreativeCommonsConfirmed,
        strDrinkAlternate, strImageSource, strInstructions, strMeal,
        strMealThumb, strSource, strTags, strYoutube, ingredientsAndMeasures
    )

}