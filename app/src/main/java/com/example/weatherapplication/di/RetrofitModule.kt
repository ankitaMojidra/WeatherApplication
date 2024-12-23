package com.example.weatherapplication.di

import com.example.weatherapplication.data.api.ApiService
import com.example.weatherapplication.data.AppConstants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {
    @Provides
    fun provideWeatherSearchService(): ApiService {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(AppConstants.BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { addApiKeyQuery(it) }.build()
            )
            .build()
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun addApiKeyQuery(chain: Interceptor.Chain) = chain.proceed(
        chain.request()
            .newBuilder()
            .url(chain.request().url.newBuilder().addQueryParameter(AppConstants.QUERY_KEY,
                AppConstants.API_KEY).build())
            .build()
    )
}