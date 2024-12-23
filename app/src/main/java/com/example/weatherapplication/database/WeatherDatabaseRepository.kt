package com.example.weatherapplication.database

import javax.inject.Inject

class WeatherDatabaseRepository @Inject constructor(
    private val weatherDatabase: WeatherDatabase
) {
    suspend fun saveViewedLocation(
        name: String?,
        lastUpdated: String?,
        tempF: Int?,
        imageUrl: String?
    ) {
        weatherDatabase.locationDao().insertSavedLocation(
            WeatherLocation(
                name = name,
                lastUpdated = lastUpdated,
                tempF = tempF,
                imageUrl = imageUrl
            )
        )
    }

    suspend fun getViewedLocations(): List<WeatherLocation> {
        return weatherDatabase.locationDao().getAllSavedLocations()
    }
}