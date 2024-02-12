package com.chrrissoft.simpletodolist.main.db.usecases.classes

import com.chrrissoft.simpletodolist.main.db.entities.TaskDao
import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.main.db.usecases.interfaces.GetTasksUseCase
import com.chrrissoft.simpletodolist.shared.ResState
import com.chrrissoft.simpletodolist.shared.ResState.Success
import com.chrrissoft.simpletodolist.utils.FlowUtils.ResFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCaseImpl @Inject constructor(
    private val dao: TaskDao,
) : GetTasksUseCase {
    override fun invoke(): Flow<ResState<Map<String, Task>>> {
        return ResFlow { dao.get().collect { data -> emit(Success(data.associateBy { it.id })) } }
    }

    override fun invoke(id: String): Flow<ResState<Task>> {
        return ResFlow { dao.get(id).collect { emit(Success(it)) } }
    }
}
