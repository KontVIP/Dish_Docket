package com.kontvip.myapplication.data.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DishDocketDao {

//    @Query("SELECT * FROM horoscope_table ORDER BY date DESC")
//    fun readAllData(): List<HoroscopeCache>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(number: HoroscopeCache)
//
//    @Query("DELETE FROM horoscope_table WHERE sign = :sign AND day = :day")
//    fun deleteHoroscope(sign: String, day: String)
//
//    @Query("SELECT * FROM horoscope_table WHERE sign = :sign AND day = :day")
//    fun horoscope(sign: String, day: String): HoroscopeCache?
}