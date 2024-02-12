package com.chrrissoft.simpletodolist.splash.view

import com.chrrissoft.simpletodolist.base.view.handler.BaseEventHandler
import com.chrrissoft.simpletodolist.base.view.viewmodel.BaseViewModel
import com.chrrissoft.simpletodolist.splash.view.SplashViewModel.EventHandler
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SplashViewModel : BaseViewModel<EventHandler, SplashState>() {
    override val eventHandler = EventHandler()
    override val _state = MutableStateFlow(SplashState())
    override val stateFlow = _state.asStateFlow()

    inner class EventHandler : BaseEventHandler()

    fun handleEvent(event: SplashEvent) {

    }

    fun updateState(
        snackbarData: SnackbarData = state.snackbar,
    ) {
        _state.update {
            it.copy(snackbar = snackbarData)
        }
    }
}
