package com.chrrissoft.simpletodolist.utils

import android.content.Context
import android.util.Log
import com.chrrissoft.simpletodolist.utils.ContextUtils.toast
import java.util.UUID

object Utils {
    @Suppress("FunctionName")
    inline fun <R> Try(
        ctx: Context? = null,
        block: () -> R?
    ): R? {
        return try {
            block()
        } catch (e: Throwable) {
            e.printStackTrace()
            val error = e.message ?: "Unknown Error"
            ctx?.toast(message = "Error $error")
            null
        }
    }

    fun Any.debug(message: Any?, tag: Any = this) {
        Log.d(tag::class.java.simpleName, message.toString())
    }

    val uuid get() = UUID.randomUUID().toString()
}
