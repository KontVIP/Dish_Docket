package com.kontvip.dishdocket.data.cloud.mapper

import com.kontvip.dishdocket.data.cache.model.meal.CacheMeal
import com.kontvip.dishdocket.data.cloud.model.meal.CloudMeal

class CloudMealToCacheMapper : CloudMeal.Mapper<CacheMeal> {
    override fun map(idMeal: String, strMeal: String, strMealThumb: String): CacheMeal {
        return CacheMeal(idMeal, strMeal, strMealThumb)
    }
}