package com.kontvip.myapplication.domain

import com.kontvip.myapplication.data.cloud.model.meal.CloudMealList

interface Repository {

    suspend fun searchByName(name: String): CloudMealList

}