package com.example.weatherapplication.data.repository

import com.example.weatherapplication.data.api.ApiService
import com.example.weatherapplication.data.model.WeatherResponse
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun loadWeatherSearchInfo(searchTerm: String): WeatherResponse {
        return apiService.loadLocationSearchInfo(
            query = searchTerm
        )
    }
}