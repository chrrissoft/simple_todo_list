package com.chrrissoft.simpletodolist.main.view

import com.chrrissoft.simpletodolist.base.view.state.BaseState
import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.main.view.MainState.SaveState.SAVED
import com.chrrissoft.simpletodolist.shared.ResState
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData

data class MainState(
    val saveState: SaveState = SAVED,
    val data: ResState<Map<String, Task>> = ResState.Loading,
    override val snackbar: SnackbarData = SnackbarData(),
) : BaseState() {
    enum class SaveState {
        UNSAVED, SAVING, SAVED
    }
}
