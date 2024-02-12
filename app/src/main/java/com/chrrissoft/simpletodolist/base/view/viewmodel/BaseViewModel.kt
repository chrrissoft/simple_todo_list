package com.chrrissoft.simpletodolist.base.view.viewmodel

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.simpletodolist.base.view.event.BaseEvent
import com.chrrissoft.simpletodolist.base.view.handler.BaseEventHandler
import com.chrrissoft.simpletodolist.base.view.state.BaseState
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData.MessageType
import com.chrrissoft.simpletodolist.utils.ComposeUtils.show
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Suppress("UNCHECKED_CAST")
abstract class BaseViewModel<H : BaseEventHandler, S : BaseState> : ViewModel() {
    private val handler = CoroutineExceptionHandler { _, e ->
        showSnackbar("Error: ${e.message}")
    }

    protected abstract val eventHandler: BaseEventHandler

    protected abstract val _state: MutableStateFlow<S>
    abstract val stateFlow: StateFlow<S>
    protected val state get() = run {
        stateFlow.value
    }

    protected val scope = viewModelScope.plus(handler)

    fun handleEvent(event: BaseEvent<H>) {
        scope.launch { event.resolve(eventHandler as H) }
    }

    protected fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) {
        scope.launch(context, start, block)
    }

    fun showSnackbar(message: String) {
        state.snackbar.state.show(scope, message)
    }

    fun showSnackbarForResult(
        message: String,
        type: MessageType,
        action: String,
        dispatcher: CoroutineContext? = null,
        onSuccessDismiss: () -> Unit,
    ) {
        scope.launch {
            val res = state.snackbar.state.show(message, actionLabel = action, duration = SnackbarDuration.Long)
            if (res == SnackbarResult.ActionPerformed && type == MessageType.Success) {
                withContext(context = dispatcher ?: this.coroutineContext) {
                    onSuccessDismiss()
                }
            }
        }
    }
}
