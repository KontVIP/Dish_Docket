package com.kontvip.myapplication.presentation.mapper

import com.kontvip.myapplication.domain.model.DomainRecipe
import com.kontvip.myapplication.domain.model.DomainRecipeList
import com.kontvip.myapplication.presentation.model.UiState

class DomainRecipeListToUiStateMapper : DomainRecipeList.Mapper<UiState> {
    override fun map(domainRecipes: List<DomainRecipe>): UiState {
        val domainRecipeMapper = object : DomainRecipe.Mapper<UiState.Recipes.Recipe> {
            override fun map(
                mealName: String, area: String, category: String, instructions: String,
                ingredientsAndMeasures: Map<String, String>, imageUrl: String,
                sourceUrl: String, youtubeUrl: String
            ): UiState.Recipes.Recipe {
                return UiState.Recipes.Recipe(
                    mealName, area, category, instructions, ingredientsAndMeasures, imageUrl,
                    sourceUrl, youtubeUrl
                )
            }
        }
        return UiState.Recipes(domainRecipes.map { it.map(domainRecipeMapper) })
    }
}