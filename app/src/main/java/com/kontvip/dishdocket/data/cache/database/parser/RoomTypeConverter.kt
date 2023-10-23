package com.kontvip.dishdocket.data.cache.database.parser

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomTypeConverter {
    @TypeConverter
    fun fromString(value: String?): Map<String, String>? {
        if (value == null) {
            return null
        }
        val mapType = object : TypeToken<Map<String, String>>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun toString(map: Map<String, String>?): String? {
        if (map == null) {
            return null
        }
        return Gson().toJson(map)
    }
}