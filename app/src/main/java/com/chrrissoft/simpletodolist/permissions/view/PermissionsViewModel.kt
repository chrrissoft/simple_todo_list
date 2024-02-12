package com.chrrissoft.simpletodolist.permissions.view

import com.chrrissoft.simpletodolist.base.view.handler.BaseEventHandler
import com.chrrissoft.simpletodolist.base.view.viewmodel.BaseViewModel
import com.chrrissoft.simpletodolist.permissions.view.PermissionsViewModel.EventHandler
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PermissionsViewModel : BaseViewModel<EventHandler, PermissionsState>() {
    override val eventHandler = EventHandler()
    override val _state = MutableStateFlow(PermissionsState())
    override val stateFlow = _state.asStateFlow()

    inner class EventHandler : BaseEventHandler()

    fun handleEvent(event: PermissionsEvent) {

    }

    fun updateState(
        snackbarData: SnackbarData = state.snackbar,
    ) {
        _state.update {
            it.copy(snackbar = snackbarData)
        }
    }
}
