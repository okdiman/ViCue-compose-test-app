package okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel

import com.adeo.kviewmodel.BaseSharedViewModel
import java.io.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okunev.projects.vicue_soft_okunev_test_app.feature.domain.VideoRepository
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainAction
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainEvent
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel :
    BaseSharedViewModel<MainState, MainAction, MainEvent>(MainState(isLoading = true)),
    KoinComponent {

    private val repository by inject<VideoRepository>()

    init {
        fetchVideos()
    }

    override fun obtainEvent(viewEvent: MainEvent) {
        when (viewEvent) {
            is MainEvent.OnTextChanged -> {
                onTextChanged(viewEvent.newText)
            }
            is MainEvent.OnPosterClick -> {
                playNewVideo(viewEvent.newUrl)
            }
            is MainEvent.OnShowButtonClick -> {
                onShowTextField()
            }
            is MainEvent.OnRetryClick -> {
                fetchVideos()
            }
            is MainEvent.OnClearTextClick -> {
                clearTextFiled()
            }
        }
    }

    private fun clearTextFiled() {
        viewState = viewState.copy(text = "")
    }

    private fun fetchVideos() {
        viewModelScope.launch(Dispatchers.IO) {
            viewState = viewState.copy(isLoading = true)
            try {
                val result = repository.fetchAllVideos()
                viewState =
                    viewState.copy(
                        items = result,
                        selectedVideoUrl = result.first().videoUrl,
                        isError = false
                    )
            } catch (e: IOException) {
                viewState = viewState.copy(isError = true)
            } finally {
                viewState = viewState.copy(isLoading = false)
            }
        }
    }

    private fun playNewVideo(newUrl: String) {
        viewState = viewState.copy(selectedVideoUrl = newUrl)
    }

    private fun onShowTextField() {
        viewState = viewState.copy(isTextFieldVisible = true)
    }

    private fun onTextChanged(text: String) {
        viewState = viewState.copy(text = text)
    }
}