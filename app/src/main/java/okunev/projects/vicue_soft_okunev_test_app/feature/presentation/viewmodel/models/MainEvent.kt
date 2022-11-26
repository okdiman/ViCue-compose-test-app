package okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models

sealed class MainEvent {
    data class OnTextChanged(val newText: String) : MainEvent()
    data class OnPosterClick(val newUrl: String) : MainEvent()
    object OnShowButtonClick : MainEvent()
    object OnRetryClick : MainEvent()
    object OnClearTextClick : MainEvent()
}