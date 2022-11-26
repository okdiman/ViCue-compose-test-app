package okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models

import okunev.projects.vicue_soft_okunev_test_app.feature.domain.model.VideoModel

data class MainState(
    val items: List<VideoModel> = emptyList(),
    val selectedVideoUrl: String = "",
    val text: String = "",
    val isTextFieldVisible: Boolean = false,
    val isError: Boolean = false,
    val isLoading: Boolean = false
)