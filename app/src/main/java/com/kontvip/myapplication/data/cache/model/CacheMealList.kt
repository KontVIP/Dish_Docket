package com.kontvip.myapplication.data.cache.model

class CacheMealList {

    fun isEmpty(): Boolean {
        TODO()
    }


    interface Mapper<T> {
        fun map(): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map()

}