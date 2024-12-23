package com.example.weatherapplication.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R

@Composable
fun LocationSearchBar(
    modifier: Modifier = Modifier,
    searchTerm: String = "",
    onSearchValueChange: (searchTerm: String) -> Unit = {}
) {

    TextField(
        modifier = modifier,
        value = searchTerm,
        onValueChange = {
            onSearchValueChange.invoke(it)
        },
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        placeholder = {
            Text(
                text = stringResource(R.string.search_location),
                fontFamily = PoppinsFontRegular
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        textStyle = TextStyle(
            fontFamily = PoppinsFontRegular
        )
    )
}

@Preview(showBackground = true)
@Composable
fun LocationSearchBarPreview() {
    LocationSearchBar()
}