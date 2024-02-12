package com.chrrissoft.simpletodolist.app.entities

import androidx.lifecycle.LifecycleRegistry
import androidx.savedstate.SavedStateRegistryController.Companion.create
import androidx.savedstate.SavedStateRegistryOwner
import javax.inject.Inject

class AwesomeSavedStateRegistryOwner @Inject constructor(override val lifecycle: LifecycleRegistry) :
    SavedStateRegistryOwner {
    val controller by lazy { create(this) }
    override val savedStateRegistry by lazy { controller.savedStateRegistry }
}
