package com.kontvip.myapplication.domain.model


class DomainRecipeList(domainRecipes: List<DomainRecipe>) : ArrayList<DomainRecipe>(domainRecipes) {

    constructor(vararg domainRecipes: DomainRecipe) : this(domainRecipes.asList())

    interface Mapper<T> {
        fun map(domainRecipes: List<DomainRecipe>): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(this)
}

data class DomainRecipe(
    private val mealName: String,
    private val area: String,
    private val category: String,
    private val instructions: String,
    private val ingredientsAndMeasures: Map<String, String>,
    private val imageUrl: String,
    private val sourceUrl: String,
    private val youtubeUrl: String,
) {
    interface Mapper<T> {
        fun map(
            mealName: String, area: String, category: String, instructions: String,
            ingredientsAndMeasures: Map<String, String>, imageUrl: String, youtubeUrl: String
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        mealName, area, category, instructions, ingredientsAndMeasures, imageUrl, youtubeUrl
    )
}