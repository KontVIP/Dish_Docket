package com.kontvip.myapplication.data.cloud.model.recipe

import com.google.gson.annotations.SerializedName

data class CloudRecipeList(
    @SerializedName("meals")
    private val cloudRecipes: List<CloudRecipe>
) {

    interface Mapper<T> {
        fun map(cloudRecipes: List<CloudRecipe>): T
    }

    fun<T> map(mapper: Mapper<T>) = mapper.map(cloudRecipes)

}