package com.chrrissoft.simpletodolist.main.db.usecases.di

import com.chrrissoft.simpletodolist.main.db.usecases.classes.GetTasksUseCaseImpl
import com.chrrissoft.simpletodolist.main.db.usecases.interfaces.GetTasksUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GetTasksUseCaseModule {
    @Binds
    abstract fun binds(impl: GetTasksUseCaseImpl): GetTasksUseCase
}
