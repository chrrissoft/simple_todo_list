package com.chrrissoft.simpletodolist.app.di

import androidx.lifecycle.LifecycleOwner
import com.chrrissoft.simpletodolist.app.entities.AwesomeLifecycleOwner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AwesomeLifecycleOwnerModule {
    @Provides
    @Singleton
    fun provide() : LifecycleOwner = AwesomeLifecycleOwner()
}
