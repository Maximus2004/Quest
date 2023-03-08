package com.example.libertex.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.libertex.R

val Cabin = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Normal),
    Font(R.font.cabin_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Cabin,
    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
        color = Color.White
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    )
)