package okunev.projects.vicue_soft_okunev_test_app.feature.presentation.compose.view

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import okunev.projects.vicue_soft_okunev_test_app.core.theme.Theme
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainEvent
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainState

@Composable
fun MainView(state: MainState, eventHandler: (MainEvent) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = {},
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back button",
                            tint = Theme.colors.primaryColor
                        )
                    }
                },
                backgroundColor = Color.White
            )
        }, content = {
            when {
                state.isLoading -> LoadingView()
                state.isError -> ErrorView(eventHandler)
                else -> SuccessView(state, eventHandler)
            }
        })
}