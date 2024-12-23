package com.example.weatherapplication.ui.screen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapplication.ui.components.HistoryCard
import com.example.weatherapplication.ui.components.PoppinsFontSemiBold
import com.example.weatherapplication.R
import com.example.weatherapplication.viewmodel.LocationSearchViewModel

@Composable
fun SearchEmptyScreen(
    context: Context? = null,
    locationSearchViewModel: LocationSearchViewModel = viewModel(),
) {
    val searchHistory = locationSearchViewModel.searchHistory.collectAsStateWithLifecycle()

    if (searchHistory.value.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.no_city_selected),
                fontSize = 25.sp,
                fontFamily = PoppinsFontSemiBold
            )
            Text(
                text = stringResource(R.string.please_search_city),
                fontSize = 15.sp,
                fontFamily = PoppinsFontSemiBold
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .padding(
                    bottom = 100.dp
                )
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    modifier = Modifier
                        .padding(
                            bottom = 5.dp
                        ),
                    text = stringResource(R.string.recently_viewed),
                    fontSize = 15.sp,
                    fontFamily = PoppinsFontSemiBold
                )
            }

            items (searchHistory.value) {
                HistoryCard(
                    modifier = Modifier.padding(
                        vertical = 2.dp
                    ),
                    context = context,
                    weatherLocation = it
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchEmptyScreenPreview() {
    SearchEmptyScreen()
}