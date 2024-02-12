package com.chrrissoft.simpletodolist.permissions.view

import com.chrrissoft.simpletodolist.base.view.state.BaseState
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData

data class PermissionsState(override val snackbar: SnackbarData = SnackbarData()) : BaseState()
