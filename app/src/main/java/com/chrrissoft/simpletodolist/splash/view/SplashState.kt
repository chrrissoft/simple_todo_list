package com.chrrissoft.simpletodolist.splash.view

import com.chrrissoft.simpletodolist.base.view.state.BaseState
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData

data class SplashState(override val snackbar: SnackbarData = SnackbarData()) : BaseState()
