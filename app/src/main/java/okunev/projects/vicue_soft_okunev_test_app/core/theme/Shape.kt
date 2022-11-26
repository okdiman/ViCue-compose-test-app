package okunev.projects.vicue_soft_okunev_test_app.core.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class ViCueShapes(
    val small: Shape,
    val medium: Shape,
    val large: Shape
)

val shapes = ViCueShapes(
    small = RoundedCornerShape(5.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(15.dp)
)

val LocalShapeProvider =
    staticCompositionLocalOf<ViCueShapes> { error("No default implementation") }