package com.example.weatherapplication.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Settings

object NetworkState {
    fun isConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        connectivityManager?.let { connectManager ->
            val capabilities = connectManager.getNetworkCapabilities(connectManager.activeNetwork)
            capabilities?.let { capability ->
                if (capability.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    capability.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    capability.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    return true
                }
            }
        }
        return false
    }

    fun isAirplaneModeOn(context: Context): Boolean {
        return Settings.System.getInt(
            context.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON,
            0) != 0
    }
}