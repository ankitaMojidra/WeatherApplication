package com.example.weatherapplication.di

import android.app.Application
import com.example.weatherapplication.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherModule(private val application: MainApplication) {
    @Provides
    @Singleton
    fun getApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideLocationDatabase(): WeatherDatabase {
        return WeatherDatabase.getDatabase(application)
    }
}