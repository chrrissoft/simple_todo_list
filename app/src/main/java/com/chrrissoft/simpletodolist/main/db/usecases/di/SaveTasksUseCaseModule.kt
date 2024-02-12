package com.chrrissoft.simpletodolist.main.db.usecases.di

import com.chrrissoft.simpletodolist.main.db.usecases.classes.SaveTasksUseCaseImpl
import com.chrrissoft.simpletodolist.main.db.usecases.interfaces.SaveTasksUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SaveTasksUseCaseModule {
    @Binds
    abstract fun binds(impl: SaveTasksUseCaseImpl): SaveTasksUseCase
}
