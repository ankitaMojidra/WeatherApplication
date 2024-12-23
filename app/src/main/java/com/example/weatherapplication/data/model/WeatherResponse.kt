package com.example.weatherapplication.data.model

import kotlin.math.roundToInt

class WeatherResponse(
    val location: Location,
    val current: Current
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtime_epoch: Long,
    val localtime: String
)

data class Current(
    val last_updated_epoch: Long,
    val last_updated: String,
    val temp_c: Double,
    val temp_f: Double,
    val is_day: Int,
    val condition: Condition,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val pressure_mb: Double,
    val pressure_in: Double,
    val precip_mm: Double,
    val precip_in: Double,
    val humidity: Int,
    val cloud: Int,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val vis_km: Double,
    val vis_miles: Double,
    val uv: Double,
    val gust_mph: Double,
    val gust_kph: Double
) {
    fun getRoundedTempF(): Int = temp_f.roundToInt()
    fun getRoundedTempC(): Int = temp_c.roundToInt()
    fun getRoundedFeelsLikeF(): Int = feelslike_f.roundToInt()
    fun getRoundedTFeelsLikeC(): Int = feelslike_c.roundToInt()
    fun getRoundedUV(): Int = uv.roundToInt()
}


data class Condition(
    val text: String,
    val icon: String,
    val code: Int
) {
    fun getImageUrl(): String = icon.replace("//", "https://")
}