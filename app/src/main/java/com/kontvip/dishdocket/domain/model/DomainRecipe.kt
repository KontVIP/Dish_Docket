package com.kontvip.dishdocket.domain.model

data class DomainRecipe(
    private val mealName: String,
    private val area: String,
    private val category: String,
    private val instructions: String,
    private val ingredientsAndMeasures: Map<String, String>,
    private val imageUrl: String,
    private val sourceUrl: String,
    private val youtubeUrl: String
) {
    interface Mapper<T> {
        fun map(
            mealName: String, area: String, category: String, instructions: String,
            ingredientsAndMeasures: Map<String, String>, imageUrl: String, sourceUrl: String, youtubeUrl: String
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        mealName, area, category, instructions, ingredientsAndMeasures, imageUrl, sourceUrl, youtubeUrl
    )
}