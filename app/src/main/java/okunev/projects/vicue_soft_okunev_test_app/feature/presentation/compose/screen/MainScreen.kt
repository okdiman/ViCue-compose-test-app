package okunev.projects.vicue_soft_okunev_test_app.feature.presentation.compose.screen

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.compose.view.MainView
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen() {
    ViewModel(factory = { MainViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        MainView(state.value) { event ->
            viewModel.obtainEvent(event)
        }
    }
}