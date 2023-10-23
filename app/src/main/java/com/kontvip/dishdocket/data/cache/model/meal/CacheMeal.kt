package com.kontvip.dishdocket.data.cache.model.meal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_table")
data class CacheMeal(
    @ColumnInfo(name = "idMeal") @PrimaryKey val idMeal: String,
    @ColumnInfo(name = "strMeal") val strMeal: String,
    @ColumnInfo(name = "strMealThumb") val strMealThumb: String
) {
    interface Mapper<T> {
        fun map(idMeal: String, strMeal: String, strMealThumb: String): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(idMeal, strMeal, strMealThumb)
}