package com.kontvip.myapplication.data.cloud.model.recipe

import com.google.gson.annotations.SerializedName

data class CloudRecipeList(
    @SerializedName("meals")
    val cloudRecipe: List<CloudRecipe>
)