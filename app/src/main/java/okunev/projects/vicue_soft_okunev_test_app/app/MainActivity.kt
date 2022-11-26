package okunev.projects.vicue_soft_okunev_test_app.app

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import okunev.projects.vicue_soft_okunev_test_app.core.theme.ViCueSoftTheme
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.compose.screen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContent {
            ViCueSoftTheme {
                MainScreen()
            }
        }
    }
}