package com.chrrissoft.simpletodolist.app.entities

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_CREATE
import androidx.lifecycle.Lifecycle.Event.ON_DESTROY
import androidx.lifecycle.Lifecycle.Event.ON_PAUSE
import androidx.lifecycle.Lifecycle.Event.ON_RESUME
import androidx.lifecycle.Lifecycle.Event.ON_START
import androidx.lifecycle.Lifecycle.Event.ON_STOP
import androidx.lifecycle.Lifecycle.State.INITIALIZED
import androidx.lifecycle.LifecycleRegistry
import androidx.savedstate.SavedStateRegistryController
import com.chrrissoft.simpletodolist.utils.Utils.Try

class LifecycleManager constructor(
    private val lifecycleRegistry: LifecycleRegistry,
    private val stateController: SavedStateRegistryController,
) {
    val state get() = lifecycleRegistry.currentState

    fun launch() {
        create()
        start()
        resume()
    }

    fun dispose() {
        pause()
        stop()
        destroy()
    }

    private fun create() {
        if (state == Lifecycle.State.RESUMED) return
        Try { lifecycleRegistry.currentState = INITIALIZED }
        Try { stateController.performAttach() }
        Try { stateController.performRestore(savedState = null) }
        lifecycleRegistry.handleLifecycleEvent(ON_CREATE)
    }

    private fun start() {
        lifecycleRegistry.handleLifecycleEvent(ON_START)
    }

    private fun resume() {
        lifecycleRegistry.handleLifecycleEvent(ON_RESUME)
    }

    private fun pause() {
        lifecycleRegistry.handleLifecycleEvent(ON_PAUSE)
    }

    private fun stop() {
        lifecycleRegistry.handleLifecycleEvent(ON_STOP)
    }

    private fun destroy() {
        lifecycleRegistry.handleLifecycleEvent(ON_DESTROY)
    }
}
