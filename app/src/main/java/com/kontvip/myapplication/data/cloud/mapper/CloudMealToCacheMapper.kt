package com.kontvip.myapplication.data.cloud.mapper

import com.kontvip.myapplication.data.cache.model.meal.CacheMeal
import com.kontvip.myapplication.data.cloud.model.meal.CloudMeal

class CloudMealToCacheMapper : CloudMeal.Mapper<CacheMeal> {
    override fun map(idMeal: String, strMeal: String, strMealThumb: String): CacheMeal {
        return CacheMeal(idMeal, strMeal, strMealThumb)
    }
}