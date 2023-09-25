package com.kontvip.myapplication.data.cloud.mapper

import com.kontvip.myapplication.data.cache.model.meal.CacheMeal
import com.kontvip.myapplication.data.cloud.model.meal.CloudMeal
import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList

class CloudMealListToCacheMapper(
    private val cloudMealToCacheMapper: CloudMeal.Mapper<CacheMeal>
) : CloudMealList.Mapper<List<CacheMeal>> {

    override fun map(cloudMeals: List<CloudMeal>?): List<CacheMeal> {
        return cloudMeals?.map { it.map(cloudMealToCacheMapper) } ?: emptyList()
    }
}
