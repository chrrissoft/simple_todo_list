package com.chrrissoft.simpletodolist.main.view

import com.chrrissoft.simpletodolist.base.view.handler.BaseEventHandler
import com.chrrissoft.simpletodolist.base.view.viewmodel.BaseViewModel
import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.main.db.usecases.interfaces.DeleteTasksUseCase
import com.chrrissoft.simpletodolist.main.db.usecases.interfaces.GetTasksUseCase
import com.chrrissoft.simpletodolist.main.db.usecases.interfaces.SaveTasksUseCase
import com.chrrissoft.simpletodolist.main.view.MainEvent.OnAddTasks
import com.chrrissoft.simpletodolist.main.view.MainEvent.OnChangeTasks
import com.chrrissoft.simpletodolist.main.view.MainEvent.OnDeleteTasks
import com.chrrissoft.simpletodolist.main.view.MainEvent.OnSaveTasks
import com.chrrissoft.simpletodolist.main.view.MainState.SaveState
import com.chrrissoft.simpletodolist.main.view.MainState.SaveState.UNSAVED
import com.chrrissoft.simpletodolist.main.view.MainViewModel.EventHandler
import com.chrrissoft.simpletodolist.shared.ResState
import com.chrrissoft.simpletodolist.ui.entities.SnackbarData
import com.chrrissoft.simpletodolist.utils.ResStateUtils.asSaveState
import com.chrrissoft.simpletodolist.utils.ResStateUtils.getSuccess
import com.chrrissoft.simpletodolist.utils.ResStateUtils.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val GetTasksUseCase: GetTasksUseCase,
    private val DeleteTasksUseCase: DeleteTasksUseCase,
    private val SaveTasksUseCase: SaveTasksUseCase,
) : BaseViewModel<EventHandler, MainState>() {
    override val eventHandler = EventHandler()
    override val _state = MutableStateFlow(MainState())
    override val stateFlow = _state.asStateFlow()

    init {
        loadTask()
    }

    inner class EventHandler : BaseEventHandler() {
        fun onEvent(event: OnAddTasks) = addTasks(event.data)

        fun onEvent(event: OnSaveTasks) = saveTasks(event.data)

        fun onEvent(event: OnChangeTasks) = changeTasks(event.data)

        fun onEvent(event: OnDeleteTasks) = deleteTasks(event.data)
    }

    private fun addTasks(data: Map<String, Task>) = changeTasks(data)

    private fun saveTasks(data: Map<String, Task>) {
        scope.launch {
            SaveTasksUseCase(data.map { it.value }).collect { updateState(it.asSaveState()) }
        }
    }

    private fun changeTasks(data: Map<String, Task>) {
        updateState(UNSAVED, state.data.map { it + data })
        state.data.getSuccess()?.let { saveTasks(it) }
    }

    private fun deleteTasks(data: Map<String, Task>) {
        updateState(data = state.data.map { it.minus(data.keys) })
        DeleteTasksUseCase(data.map { it.value }).launchIn(scope)
    }


    private fun loadTask() = collectsTask { updateState(data = it) }

    private fun collectsTask(block: suspend CoroutineScope.(ResState<Map<String, Task>>) -> Unit) =
        scope.launch { GetTasksUseCase().collect { block(it) } }


    private fun updateState(
        saveState: SaveState = state.saveState,
        data: ResState<Map<String, Task>> = state.data,
        snackbarData: SnackbarData = state.snackbar,
    ) = _state.update { it.copy(saveState = saveState, data = data, snackbar = snackbarData) }
}
