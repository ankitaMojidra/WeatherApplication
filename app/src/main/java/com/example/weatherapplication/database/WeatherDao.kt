package com.example.weatherapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedLocation(weatherLocation: WeatherLocation)

    @Query("SELECT * FROM weatherlocation")
    suspend fun getAllSavedLocations(): List<WeatherLocation>
}