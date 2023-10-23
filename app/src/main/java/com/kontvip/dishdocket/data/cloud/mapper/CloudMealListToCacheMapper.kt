package com.kontvip.dishdocket.data.cloud.mapper

import com.kontvip.dishdocket.data.cache.model.meal.CacheMeal
import com.kontvip.dishdocket.data.cloud.model.meal.CloudMeal
import com.kontvip.dishdocket.data.cloud.model.meal.CloudMealList

class CloudMealListToCacheMapper(
    private val cloudMealToCacheMapper: CloudMeal.Mapper<CacheMeal>
) : CloudMealList.Mapper<List<CacheMeal>> {

    override fun map(cloudMeals: List<CloudMeal>?): List<CacheMeal> {
        return cloudMeals?.map { it.map(cloudMealToCacheMapper) } ?: emptyList()
    }
}
