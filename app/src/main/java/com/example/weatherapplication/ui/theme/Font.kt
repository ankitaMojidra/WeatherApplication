package com.example.weatherapplication.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapplication.R

val PoppinsFontLight = FontFamily(
    Font(R.font.poppins_extra_light),
)

val PoppinsFontRegular = FontFamily(
    Font(R.font.poppins_regular)
)

val PoppinsFontMedium = FontFamily(
    Font(R.font.poppins_medium)
)

val PoppinsFontSemiBold = FontFamily(
    Font(R.font.poppins_semi_bold)
)


@Preview(showBackground = true)
@Composable
fun PoppinsFontPreview() {
    Column {
        Text(
            text = "Testing Poppins Font",
            fontFamily = PoppinsFontLight
        )
        Text(
            text = "Testing Poppins Font",
            fontFamily = PoppinsFontRegular
        )
        Text(
            text = "Testing Poppins Font",
            fontFamily = PoppinsFontMedium
        )
        Text(
            text = "Testing Poppins Font",
            fontFamily = PoppinsFontSemiBold
        )
    }
}