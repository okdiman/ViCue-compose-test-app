package okunev.projects.vicue_soft_okunev_test_app.core.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun ViCueSoftTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalShapeProvider provides shapes,
        LocalColorProvider provides palette,
        content = content
    )
}

object Theme {
    val colors: ViCueColors
        @Composable
        get() = LocalColorProvider.current
    val shapes: ViCueShapes
        @Composable
        get() = LocalShapeProvider.current
}