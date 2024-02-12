package com.chrrissoft.simpletodolist.utils

import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.widget.Toast
import android.widget.Toast.makeText

object ContextUtils {
    fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        makeText(this, message, duration).show()
    }

    fun Context.isPermissionEnabled(permission: String) : Boolean {
        return checkSelfPermission(permission) == PERMISSION_GRANTED
    }
}
