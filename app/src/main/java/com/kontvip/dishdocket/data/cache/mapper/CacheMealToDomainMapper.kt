package com.kontvip.dishdocket.data.cache.mapper

import com.kontvip.dishdocket.data.cache.model.meal.CacheMeal
import com.kontvip.dishdocket.domain.model.DomainMeal

class CacheMealToDomainMapper : CacheMeal.Mapper<DomainMeal> {

    override fun map(idMeal: String, strMeal: String, strMealThumb: String): DomainMeal {
        return DomainMeal(idMeal, strMeal, strMealThumb)
    }
}