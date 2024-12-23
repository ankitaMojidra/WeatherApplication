package com.example.weatherapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class  WeatherLocation(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "lastUpdated") val lastUpdated: String?,
    @ColumnInfo(name = "tempF") val tempF: Int?,
    @ColumnInfo(name = "imageUrl") val imageUrl: String?
)