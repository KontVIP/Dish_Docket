package com.kontvip.myapplication.data.cloud.model.meal

data class CloudMealList(
    private val cloudMeals: List<CloudMeal>?
) {

    interface Mapper<T> {
        fun map(cloudMeals: List<CloudMeal>?): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(cloudMeals)

}