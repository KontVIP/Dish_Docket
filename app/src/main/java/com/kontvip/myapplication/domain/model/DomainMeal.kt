package com.kontvip.myapplication.domain.model

class DomainMealList(domainMeals: List<DomainMeal>) : ArrayList<DomainMeal>(domainMeals) {

    constructor(vararg domainMeals: DomainMeal) : this(domainMeals.asList())

    interface Mapper<T> {
        fun map(domainMeals: List<DomainMeal>): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(this)
}

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