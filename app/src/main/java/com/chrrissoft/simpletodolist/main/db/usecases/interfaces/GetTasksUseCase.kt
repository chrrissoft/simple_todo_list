package com.chrrissoft.simpletodolist.main.db.usecases.interfaces

import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.shared.ResState
import kotlinx.coroutines.flow.Flow

interface GetTasksUseCase {
    operator fun invoke(): Flow<ResState<Map<String, Task>>>

    operator fun invoke(id: String): Flow<ResState<Task>>
}
