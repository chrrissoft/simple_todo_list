package com.chrrissoft.simpletodolist.main.db.usecases.interfaces

import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.shared.ResState
import kotlinx.coroutines.flow.Flow

interface DeleteTasksUseCase {
    operator fun invoke(data: List<Task>): Flow<ResState<Any>>

    operator fun invoke(vararg data: Task): Flow<ResState<Any>> {
        return invoke(data.toList())
    }
}