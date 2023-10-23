package com.kontvip.myapplication.domain.model

class DomainMealList(domainMeals: List<DomainMeal>) : ArrayList<DomainMeal>(domainMeals) {

    constructor(vararg domainMeals: DomainMeal) : this(domainMeals.asList())

    interface Mapper<T> {
        fun map(domainMeals: List<DomainMeal>): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(this)
}