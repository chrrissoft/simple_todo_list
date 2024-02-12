package com.chrrissoft.simpletodolist.app.di

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LifecycleRegistryModule {
    @Provides
    fun provide(owner: LifecycleOwner): LifecycleRegistry =
        owner.lifecycle as LifecycleRegistry
}
