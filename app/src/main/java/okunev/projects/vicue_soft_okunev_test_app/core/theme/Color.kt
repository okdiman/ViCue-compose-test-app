package okunev.projects.vicue_soft_okunev_test_app.core.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ViCueColors(
    val primaryColor: Color,
    val primaryBackgroundColor: Color,
    val hintColor: Color,
    val textPrimaryColor: Color,
    val textSecondaryColor: Color
)

val palette = ViCueColors(
    primaryColor = Color(0xFF6371DE),
    textPrimaryColor = Color.White,
    primaryBackgroundColor = Color.LightGray,
    textSecondaryColor = Color(0xFF65DE63),
    hintColor = Color.LightGray
)

val LocalColorProvider =
    staticCompositionLocalOf<ViCueColors> { error("No default implementation") }