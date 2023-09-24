package com.kontvip.myapplication.data.cloud.model.meal

import com.google.gson.annotations.SerializedName

data class CloudMealList(
    @SerializedName("meals")
    val cloudMeals: List<CloudMeal>?
) {

    interface Mapper<T> {
        fun map(cloudMeals: List<CloudMeal>?): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(cloudMeals)

}