package com.example.weatherapplication.ui.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.weatherapplication.ui.components.PoppinsFontSemiBold
import com.example.weatherapplication.ui.components.WeatherCard
import com.example.weatherapplication.R
import com.example.weatherapplication.viewmodel.LocationSearchViewModel
import androidx.compose.material3.Text as Text1

@Composable
fun LocationInfoScreen(
    context: Context? = null,
    locationSearchViewModel: LocationSearchViewModel = viewModel()
) {
    val locationSearch by locationSearchViewModel.locationSearch.collectAsStateWithLifecycle()
    val currentWeather by locationSearchViewModel.currentWeather.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageRequest = context?.let {
            ImageRequest.Builder(it)
                .data(currentWeather?.condition?.getImageUrl())
                .memoryCacheKey(currentWeather?.condition?.getImageUrl())
                .diskCacheKey(currentWeather?.condition?.getImageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .diskCachePolicy(CachePolicy.ENABLED)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .build()
        }

        AsyncImage(
            modifier = Modifier
                .size(150.dp)
                .padding(
                    top = 30.dp,
                ),
            model = imageRequest,
            contentDescription = "Weather Image",
            contentScale = ContentScale.Crop
        )

        Row (
            modifier = Modifier
                .wrapContentSize()
                .padding(
                    top = 20.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            locationSearch?.name?.let {
                Text1 (
                    text = it,
                    fontSize = 27.sp,
                    fontFamily = PoppinsFontSemiBold
                )
            }

            Image(
                modifier = Modifier
                .size(25.dp)
                .padding(
                    start = 7.dp,
                ),
                painter = painterResource(id = R.drawable.ic_location_arrow),
                contentDescription = "Location Arrow Icon"
            )
        }

        Row (
            modifier = Modifier
                .wrapContentSize()
                .padding(
                    top = 10.dp,
                ),
            horizontalArrangement = Arrangement.Center
        ) {
            currentWeather?.getRoundedTempF()?.let {
                Text1 (
                    text = String.format(stringResource(R.string.format_int), it),
                    fontSize = 70.sp,
                    fontFamily = PoppinsFontSemiBold
                )
            }

            Image(
                modifier = Modifier
                    .padding(
                        top = 12.dp,
                    )
                    .size(8.dp),
                painter = painterResource(id = R.drawable.ic_degree_ellipse),
                contentDescription = "Degree Icon"
            )
        }

        WeatherCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 35.dp,
                    end = 35.dp
                ),
            currentWeather = currentWeather
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LocationInfoScreenPreview() {
    LocationInfoScreen()
}