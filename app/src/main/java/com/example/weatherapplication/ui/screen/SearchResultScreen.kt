package com.example.weatherapplication.ui.screen

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapplication.ui.components.SearchCard
import com.example.weatherapplication.viewmodel.LocationSearchViewModel

@Composable
fun SearchResulrScreen(
    context: Context? = null,
    locationSearchViewModel: LocationSearchViewModel = viewModel(),
    clickWeatherInfo: () -> Unit = {}
) {
    val locationSearch by locationSearchViewModel.locationSearch.collectAsStateWithLifecycle()
    val currentWeather by locationSearchViewModel.currentWeather.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if ((locationSearch != null) && (currentWeather != null)) {
            SearchCard(
                modifier = Modifier
                    .fillMaxWidth(),
                context = context,
                locationSearch = locationSearch,
                currentWeather = currentWeather,
                clickWeatherInfo = clickWeatherInfo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchFoundScreenPreview() {
    SearchResulrScreen()
}