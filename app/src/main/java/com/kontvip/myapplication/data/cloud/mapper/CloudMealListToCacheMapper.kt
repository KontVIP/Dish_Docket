package com.kontvip.myapplication.data.cloud.mapper

import com.kontvip.myapplication.data.cloud.model.meal.CloudMeal
import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList
import com.kontvip.myapplication.domain.model.DomainMealList

class CloudMealListToCacheMapper : CloudMealList.Mapper<DomainMealList> {
    override fun map(cloudMeals: List<CloudMeal>?): DomainMealList {
        TODO("Not yet implemented")
    }
}