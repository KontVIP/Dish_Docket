package com.kontvip.myapplication.data.cloud.mapper

import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipe
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipe
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipeList

class CloudRecipeListToCacheMapper(
    private val cloudRecipeToCacheMapper: CloudRecipe.Mapper<CacheRecipe>
) : CloudRecipeList.Mapper<List<CacheRecipe>> {

    override fun map(cloudRecipes: List<CloudRecipe>): List<CacheRecipe> {
        return cloudRecipes.map { it.map(cloudRecipeToCacheMapper) }
    }

}