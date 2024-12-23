package com.example.weatherapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WeatherLocation::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun locationDao() : WeatherDao

    companion object {
        private const val DATABASE_SAVED_LOCATION = "app_saved_locations"

        @Volatile
        private var instance: WeatherDatabase? = null

        fun getDatabase(context: Context): WeatherDatabase {
            if (instance == null) {
                synchronized(WeatherDatabase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context, WeatherDatabase::class.java, DATABASE_SAVED_LOCATION
                        )
                            .fallbackToDestructiveMigration()
                            .enableMultiInstanceInvalidation()
                            .build()
                    }
                }
            }

            return instance!!
        }
    }
}