package com.kontvip.myapplication.data.cache.mapper

import com.kontvip.myapplication.data.cache.model.meal.CacheMeal
import com.kontvip.myapplication.domain.model.DomainMeal

class CacheMealToDomainMapper : CacheMeal.Mapper<DomainMeal> {

    override fun map(idMeal: String, strMeal: String, strMealThumb: String): DomainMeal {
        return DomainMeal(idMeal, strMeal, strMealThumb)
    }
}