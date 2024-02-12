package com.chrrissoft.simpletodolist.main.db.usecases.classes

import com.chrrissoft.simpletodolist.main.db.entities.TaskDao
import com.chrrissoft.simpletodolist.main.db.models.Task
import com.chrrissoft.simpletodolist.main.db.usecases.interfaces.DeleteTasksUseCase
import com.chrrissoft.simpletodolist.shared.ResState
import com.chrrissoft.simpletodolist.shared.ResState.Success
import com.chrrissoft.simpletodolist.utils.FlowUtils.ResFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteTasksUseCaseImpl @Inject constructor(
    private val dao: TaskDao,
) :  DeleteTasksUseCase {
    override fun invoke(data: List<Task>): Flow<ResState<Any>> {
        return ResFlow { emit(Success(dao.delete(data))) }
    }
}
