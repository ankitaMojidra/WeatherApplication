package com.example.weatherapplication.data.api

import com.example.weatherapplication.data.AppConstants
import com.example.weatherapplication.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current.json")
    suspend fun loadLocationSearchInfo(
        @Query("q") query: String,
        @Query("aqi") ts: String = AppConstants.QUERY_AQI_NO,
    ): WeatherResponse
}