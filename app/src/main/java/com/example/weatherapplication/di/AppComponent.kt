package com.example.weatherapplication.di

import com.example.weatherapplication.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [WeatherModule::class, RetrofitModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun appModule(module: WeatherModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
    fun inject(mainActivity: MainActivity)
}