package com.chrrissoft.simpletodolist.app.di

import androidx.lifecycle.LifecycleRegistry
import androidx.savedstate.SavedStateRegistryController
import com.chrrissoft.simpletodolist.app.entities.LifecycleManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LifecycleManagerModule {
    @Provides
    fun provide(
        lifecycleRegistry: LifecycleRegistry,
        stateController: SavedStateRegistryController,
    ) : LifecycleManager {
        return LifecycleManager(lifecycleRegistry, stateController)
    }
}
