package com.chrrissoft.simpletodolist.app.entities

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import javax.inject.Inject

class AwesomeLifecycleOwner @Inject constructor() : LifecycleOwner {
    override val lifecycle = LifecycleRegistry(provider = this)
}
