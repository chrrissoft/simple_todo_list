package com.chrrissoft.simpletodolist.main.view

import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.main.view.MainEvent.OnAddTasks
import com.chrrissoft.simpletodolist.main.view.MainEvent.OnChangeTasks
import com.chrrissoft.simpletodolist.main.view.MainEvent.OnDeleteTasks
import com.chrrissoft.simpletodolist.main.view.MainEvent.OnSaveTasks
import com.chrrissoft.simpletodolist.ui.components.Screen
import com.chrrissoft.simpletodolist.ui.components.SimpleTodoListSnackbar
import com.chrrissoft.simpletodolist.utils.ResStateUtils.getSuccess
import com.chrrissoft.simpletodolist.utils.Utils.uuid

@Composable
fun MainScreen(
    state: MainState,
    onEvent: (MainEvent) -> Unit,
) {
    Screen(
        padding = false,
        floatingActionButton = {
            val icon = when (state.saveState) {
                MainState.SaveState.SAVED -> Rounded.Add
                MainState.SaveState.SAVING -> Rounded.Favorite
                MainState.SaveState.UNSAVED -> Rounded.Save
            }
            FloatingActionButton(
                content = { Icon(icon, (null)) },
                onClick = {
                    when (state.saveState) {
                        MainState.SaveState.SAVED ->
                            onEvent(OnChangeTasks((uuid to Task(uuid))))

                        MainState.SaveState.UNSAVED ->
                            state.data.getSuccess()?.let { onEvent(OnSaveTasks(it)) }

                        MainState.SaveState.SAVING -> {}
                    }
                },
                containerColor = colorScheme.background,
                contentColor = colorScheme.onBackground,
            )
        },
        snackbarHost = { SimpleTodoListSnackbar(state = state.snackbar) },
        content = {
            SimpleTasks(
                state = state.data,
                onAdd = { onEvent(OnAddTasks(it)) },
                onChange = { onEvent(OnChangeTasks(it)) },
                onDelete = { onEvent(OnDeleteTasks(it)) },
            )
        },
    )
}
