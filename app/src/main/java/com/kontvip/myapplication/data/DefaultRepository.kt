package com.kontvip.myapplication.data

import com.kontvip.myapplication.core.AppDispatchers
import com.kontvip.myapplication.data.cache.CacheSource
import com.kontvip.myapplication.data.cache.model.CacheMealList
import com.kontvip.myapplication.data.cloud.CloudSource
import com.kontvip.myapplication.domain.Repository
import kotlinx.coroutines.withContext

class DefaultRepository(
    private val cloudSource: CloudSource,
    private val cacheSource: CacheSource,
    private val cloudMealListToCacheMapper: CloudMealListToCacheMapper,
    private val cacheMealListToDomainMapper: CacheMealListToDomainMapper
) : Repository {

    override suspend fun searchByName(name: String): DomainMealList {
        val cacheMealList = cacheSource.mealsByName(name = name)
        if (cacheMealList.isEmpty()) { //todo: create isEmpty() method
            val cloudMealList = cloudSource.mealsByName(name = name)
            val cloudMealListAsCache = cloudMealListToCacheMapper.map(cloudMealList)
            cacheSource.saveMealByName(cloudMealListAsCache)
            return cacheMealListToDomainMapper.map(cloudMealListAsCache)
        } else {
            return cacheMealListToDomainMapper.map(cacheMealList)
        }
    }
}