package com.chrrissoft.simpletodolist.demo.view

import com.chrrissoft.simpletodolist.base.view.state.BaseState
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData

data class DemoState(override val snackbar: SnackbarData = SnackbarData()) : BaseState()
