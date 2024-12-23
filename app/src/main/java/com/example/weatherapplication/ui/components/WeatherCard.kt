package com.example.weatherapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.data.model.Current
import com.example.weatherapplication.ui.theme.PoppinsFontRegular
import com.example.weatherapplication.ui.theme.PoppinsFontSemiBold

@Composable
fun WeatherCard(
    modifier: Modifier = Modifier,
    currentWeather: Current? = null,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 15.dp,
                    bottom = 15.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(
                        start = 20.dp
                    )
                    .wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text (
                    modifier = Modifier
                        .wrapContentSize(),
                    text = String.format(stringResource(R.string.status_humidity)),
                    fontSize = 12.sp,
                    fontFamily = PoppinsFontRegular
                )

                currentWeather?.humidity?.let {
                    Text (
                        modifier = Modifier
                            .wrapContentSize(),
                        text = String.format(stringResource(R.string.format_percentage), it),
                        fontSize = 15.sp,
                        fontFamily = PoppinsFontSemiBold
                    )
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text (
                    modifier = Modifier
                        .wrapContentSize(),
                    text = String.format(stringResource(R.string.status_uv)),
                    fontSize = 12.sp,
                    fontFamily = PoppinsFontRegular
                )

                currentWeather?.getRoundedUV()?.let {
                    Text (
                        modifier = Modifier
                            .wrapContentSize(),
                        text = String.format(stringResource(R.string.format_int), it),
                        fontSize = 15.sp,
                        fontFamily = PoppinsFontSemiBold
                    )
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(
                        end = 20.dp
                    )
                    .wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text (
                    modifier = Modifier
                        .wrapContentSize(),
                    text = String.format(stringResource(R.string.status_feels_like)),
                    fontSize = 12.sp,
                    fontFamily = PoppinsFontRegular
                )

                currentWeather?.getRoundedFeelsLikeF()?.let {
                    Text (
                        modifier = Modifier
                            .wrapContentSize(),
                        text = String.format(stringResource(R.string.format_temperature_f), it),
                        fontSize = 15.sp,
                        fontFamily = PoppinsFontSemiBold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherCardPreview() {
    WeatherCard()
}