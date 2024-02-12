package com.chrrissoft.simpletodolist.app.di

import androidx.lifecycle.LifecycleRegistry
import androidx.savedstate.SavedStateRegistryOwner
import com.chrrissoft.simpletodolist.app.entities.AwesomeSavedStateRegistryOwner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AwesomeSavedStateRegistryOwnerModule {
    @Provides
    @Singleton
    fun provide(lifecycle: LifecycleRegistry): SavedStateRegistryOwner =
        AwesomeSavedStateRegistryOwner(lifecycle)
}
