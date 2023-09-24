package com.kontvip.myapplication.data.cache.model.meal

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "meal_table", primaryKeys = ["idMeal"])
data class CacheMeal(
    @ColumnInfo(name = "idMeal")
    val idMeal: String,
    @ColumnInfo(name = "strMeal")
    val strMeal: String,
    @ColumnInfo(name = "strMealThumb")
    val strMealThumb: String
)