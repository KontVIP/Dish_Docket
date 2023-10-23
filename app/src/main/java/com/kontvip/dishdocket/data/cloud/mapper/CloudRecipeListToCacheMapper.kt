package com.kontvip.dishdocket.data.cloud.mapper

import com.kontvip.dishdocket.data.cache.model.recipe.CacheRecipe
import com.kontvip.dishdocket.data.cloud.model.recipe.CloudRecipe
import com.kontvip.dishdocket.data.cloud.model.recipe.CloudRecipeList

class CloudRecipeListToCacheMapper(
    private val cloudRecipeToCacheMapper: CloudRecipe.Mapper<CacheRecipe>
) : CloudRecipeList.Mapper<List<CacheRecipe>> {

    override fun map(cloudRecipes: List<CloudRecipe>): List<CacheRecipe> {
        return cloudRecipes.map { it.map(cloudRecipeToCacheMapper) }
    }

}