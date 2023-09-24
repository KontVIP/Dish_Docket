package com.kontvip.myapplication.data.cache.model.meal


data class CacheMealList(private val id: String) {

    fun isEmpty(): Boolean = id.isEmpty()

    interface Mapper<T> {
        fun map(): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map()

}