package com.kontvip.myapplication.data.cloud.model.recipe

import com.google.gson.annotations.SerializedName

data class CloudRecipeList(
    @SerializedName("meals")
    val cloudRecipe: List<CloudRecipe>
) {

    interface Mapper<T> {
        fun map(): T
    }

    fun<T> map(mapper: Mapper<T>) = mapper.map()

}