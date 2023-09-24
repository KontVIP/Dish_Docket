package com.kontvip.myapplication.data.cache.model.recipe


abstract class CacheRecipeList(private val id: String) {

    abstract fun isEmpty(): Boolean


    data class Default(private val id: String) : CacheRecipeList(id) {

        override fun isEmpty(): Boolean = id.isNotEmpty()
    }

    interface Mapper<T> {
        fun map(): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map()

    class Empty : CacheRecipeList("") {
        override fun isEmpty(): Boolean = true
    }
}
