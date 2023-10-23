package com.kontvip.dishdocket.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kontvip.dishdocket.data.cache.database.parser.RoomTypeConverter
import com.kontvip.dishdocket.data.cache.model.meal.CacheMeal
import com.kontvip.dishdocket.data.cache.model.recipe.CacheRecipe

@Database(entities = [CacheMeal::class, CacheRecipe::class], version = 1)
@TypeConverters(RoomTypeConverter::class)
abstract class DishDocketDatabase : RoomDatabase() {
    abstract fun dishDocketDao(): DishDocketDao
}