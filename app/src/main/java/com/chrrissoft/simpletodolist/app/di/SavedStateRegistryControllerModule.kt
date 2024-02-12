package com.chrrissoft.simpletodolist.app.di

import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import com.chrrissoft.simpletodolist.app.entities.AwesomeSavedStateRegistryOwner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SavedStateRegistryControllerModule {
    @Provides
    fun provideAnimationsBinding(owner: SavedStateRegistryOwner): SavedStateRegistryController =
        (owner as AwesomeSavedStateRegistryOwner).controller
}
