package com.kontvip.dishdocket.presentation.mapper

import com.kontvip.dishdocket.domain.model.DomainRecipe
import com.kontvip.dishdocket.domain.model.DomainRecipeList
import com.kontvip.dishdocket.presentation.model.UiRecipe
import com.kontvip.dishdocket.presentation.model.UiState

class DomainRecipeListToUiStateMapper : DomainRecipeList.Mapper<UiState> {
    override fun map(domainRecipes: List<DomainRecipe>): UiState {
        val domainRecipeMapper = object : DomainRecipe.Mapper<UiRecipe> {
            override fun map(
                mealName: String, area: String, category: String, instructions: String,
                ingredientsAndMeasures: Map<String, String>, imageUrl: String,
                sourceUrl: String, youtubeUrl: String
            ): UiRecipe {
                return UiRecipe(
                    mealName, area, category, instructions,
                    ingredientsAndMeasures, imageUrl, sourceUrl, youtubeUrl
                )
            }
        }
        return UiState.Recipes(domainRecipes.map { it.map(domainRecipeMapper) })
    }
}