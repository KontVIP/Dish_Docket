package com.kontvip.myapplication.data.cloud.model.meal

data class CloudMeal(
    private val idMeal: String,
    private val strMeal: String,
    private val strMealThumb: String
) {
    interface Mapper<T> {
        fun map(idMeal: String, strMeal: String, strMealThumb: String): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(idMeal, strMeal, strMealThumb)
}