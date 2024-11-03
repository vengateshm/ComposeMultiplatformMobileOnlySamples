package dev.vengateshm.compose.multiplatform.mobile.samples.color_picker

import androidx.compose.ui.graphics.Color

data class ColorItem(
    val name: String,
    val color: Color
)

val colorList = listOf(
    ColorItem(
        name = "LightBlue",
        color = Color(0xFF81D4FA)
    ),
    ColorItem(
        name = "DeepOrange",
        color = Color(0xFFFF5722)
    ),
    ColorItem(
        name = "SemiTransparentRed",
        color = Color(0x80FF0000)
    ),
    ColorItem(
        name = "TransparentBlack",
        color = Color(0x66000000)
    ),
    ColorItem(
        name = "PaleYellow",
        color = Color(0xFFFFF9C4)
    ),
    ColorItem(
        name = "LightGreen",
        color = Color(0xFFB2FF59)
    ),
    ColorItem(
        name = "DarkPurple",
        color = Color(0xFF4A148C)
    ),
    ColorItem(
        name = "SemiTransparentOrange",
        color = Color(0x80FFA726)
    ),
)
