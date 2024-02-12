package com.chrrissoft.simpletodolist.main.db.usecases.di

import com.chrrissoft.simpletodolist.main.db.usecases.classes.DeleteTasksUseCaseImpl
import com.chrrissoft.simpletodolist.main.db.usecases.interfaces.DeleteTasksUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DeleteTasksUseCaseModule {
    @Binds
    abstract fun binds(impl: DeleteTasksUseCaseImpl): DeleteTasksUseCase
}
