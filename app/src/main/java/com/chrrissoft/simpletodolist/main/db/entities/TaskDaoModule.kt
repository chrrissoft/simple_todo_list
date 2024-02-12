package com.chrrissoft.simpletodolist.main.db.entities

import com.chrrissoft.simpletodolist.db.SimpleTodoListAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TaskDaoModule {
    @Provides
    fun provides(db: SimpleTodoListAppDatabase) : TaskDao = db.tasksDao
}
