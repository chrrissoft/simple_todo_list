package com.chrrissoft.simpletodolist.main.view

import com.chrrissoft.simpletodolist.base.view.event.BaseEvent
import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.main.view.MainViewModel.EventHandler

sealed interface MainEvent : BaseEvent<EventHandler> {
    override fun resolve(handler: EventHandler) {
        when (this) {
            is OnAddTasks -> handler.onEvent(event = this)
            is OnSaveTasks -> handler.onEvent(event = this)
            is OnChangeTasks -> handler.onEvent(event = this)
            is OnDeleteTasks -> handler.onEvent(event = this)
        }
    }

    data class OnSaveTasks(val data: Map<String, Task>) : MainEvent {
        constructor(data: Pair<String, Task>) : this(mapOf(data))
    }

    data class OnChangeTasks(val data: Map<String, Task>) : MainEvent {
        constructor(data: Pair<String, Task>) : this(mapOf(data))
    }

    data class OnDeleteTasks(val data: Map<String, Task>) : MainEvent {
        constructor(data: Pair<String, Task>) : this(mapOf(data))
    }

    data class OnAddTasks(val data: Map<String, Task>) : MainEvent {
        constructor(data: Pair<String, Task>) : this(mapOf(data))
    }
}
