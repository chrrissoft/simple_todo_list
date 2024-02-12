package com.chrrissoft.simpletodolist.shared

import com.chrrissoft.simpletodolist.utils.Utils.debug

sealed interface ResState<out R> {
    object None : ResState<Nothing>

    object Loading : ResState<Nothing>

    data class Success<R>(val data: R) : ResState<R>

    data class Error(val throwable: Throwable?) : ResState<Nothing> {
        constructor(e: Error) : this(e.throwable)

        init {
            debug(throwable?.printStackTrace())
        }

        val message get() = throwable?.message ?: "Unknown error"
    }

    companion object {
        @Suppress("FunctionName")
        fun<T> SuccessOrNone(data: T?) : ResState<T> {
            return if (data == null) None else Success(data)
        }
    }
}
