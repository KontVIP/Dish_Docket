package com.kontvip.myapplication.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kontvip.myapplication.data.cache.database.parser.RoomTypeConverter
import com.kontvip.myapplication.data.cache.model.meal.CacheMeal
import com.kontvip.myapplication.data.cache.model.recipe.CacheRecipe

@Database(entities = [CacheMeal::class, CacheRecipe::class], version = 1)
@TypeConverters(RoomTypeConverter::class)
abstract class DishDocketDatabase : RoomDatabase() {
    abstract fun dishDocketDao(): DishDocketDao
}