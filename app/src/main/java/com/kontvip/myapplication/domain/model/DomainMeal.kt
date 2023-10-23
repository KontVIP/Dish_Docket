package com.kontvip.myapplication.domain.model

data class DomainMeal(
    private val mealId: String,
    private val mealName: String,
    private val imageUrl: String
) {

    interface Mapper<T> {
        fun map(mealId: String, mealName: String, imageUrl: String): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(mealId, mealName, imageUrl)
}