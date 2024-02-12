package com.chrrissoft.simpletodolist.di

import androidx.work.Configuration
import androidx.work.Configuration.Builder
import com.chrrissoft.simpletodolist.android.SimpleTodoListWorkerFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object WorkManagerConfigurationModule {
    @Provides
    fun provide(factory: SimpleTodoListWorkerFactory) : Configuration {
        return Builder()
            .setWorkerFactory(factory)
            .build()
    }
}
