package com.chrrissoft.simpletodolist.main.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction.Companion.Next
import androidx.compose.ui.unit.dp
import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.shared.ResState
import com.chrrissoft.simpletodolist.shared.ResStateListMap
import com.chrrissoft.simpletodolist.ui.components.SimpleTask
import com.chrrissoft.simpletodolist.utils.Utils.uuid
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SimpleTasks(
    state: ResState<Map<String, Task>>,
    onAdd: (Map<String, Task>) -> Unit,
    onChange: (Map<String, Task>) -> Unit,
    onDelete: (Map<String, Task>) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    ResStateListMap(state = state, modifier) { res ->
        val list = res.toList()
        if (res.isEmpty()) {
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) { Text(text = "Tap the + button to add a task") }
            }
        }
        itemsIndexed(list) { index, task ->
            val isLast = list.lastIndex == index
            SimpleTask(
                task = task.second.task,
                complete = task.second.complete,
                onDelete = { onDelete(mapOf(task)) },
                onTaskChange = { onChange(mapOf(task.copy(second = task.second.copy(task = it)))) },
                onCompleteChange = { comp ->
                    task.second.copy(complete = comp)
                        .let { mapOf(task.copy(second = it)) }.let(onChange)
                },
                keyboardActions = KeyboardActions(onNext = {
                    if (isLast) {
                        onAdd(mapOf(uuid to Task(uuid)))
                        scope.launch { delay((100)).apply { defaultKeyboardAction(Next) } }
                    } else defaultKeyboardAction(Next)
                }),
            )
        }
        item {
            Spacer(modifier = Modifier.height(200.dp))
        }
    }
}
