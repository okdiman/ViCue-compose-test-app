package okunev.projects.vicue_soft_okunev_test_app.core

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) :
    BaseSharedViewModel<State, Action, Event>(initialState) {

    override fun obtainEvent(viewEvent: Event) {}

    fun launchJob(
        context: CoroutineContext = EmptyCoroutineContext,
        onError: (t: Throwable) -> Unit = {},
        onFinally: () -> Unit = {},
        job: suspend () -> Unit
    ) {
        viewModelScope.launch(context) {
            try {
                job()
            } catch (t: Throwable) {
                onError(t)
            } finally {
                onFinally()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.coroutineContext.cancel()
    }
}