package com.chrrissoft.simpletodolist.utils

import com.chrrissoft.simpletodolist.shared.ResState
import com.chrrissoft.simpletodolist.shared.ResState.Error
import com.chrrissoft.simpletodolist.shared.ResState.Loading
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

object FlowUtils {
    @Suppress("FunctionName")
    fun <T> ResFlow(
        context: CoroutineContext = Dispatchers.IO,
        block: suspend FlowCollector<ResState<T>>.() -> Unit
    ): Flow<ResState<T>> {
        return flow { emit(Loading).apply { block() } }.flowOn(context).catch { emit(Error(it)) }
    }
}