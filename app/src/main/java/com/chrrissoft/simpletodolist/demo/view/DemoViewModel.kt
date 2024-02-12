package com.chrrissoft.simpletodolist.demo.view

import com.chrrissoft.simpletodolist.base.view.handler.BaseEventHandler
import com.chrrissoft.simpletodolist.base.view.viewmodel.BaseViewModel
import com.chrrissoft.simpletodolist.demo.view.DemoViewModel.EventHandler
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DemoViewModel : BaseViewModel<EventHandler, DemoState>() {
    override val eventHandler = EventHandler()
    override val _state = MutableStateFlow(DemoState())
    override val stateFlow = _state.asStateFlow()

    inner class EventHandler : BaseEventHandler()

    fun handleEvent(event: DemoEvent) {

    }

    fun updateState(
        snackbarData: SnackbarData = state.snackbar,
    ) {
        _state.update {
            it.copy(snackbar = snackbarData)
        }
    }
}
