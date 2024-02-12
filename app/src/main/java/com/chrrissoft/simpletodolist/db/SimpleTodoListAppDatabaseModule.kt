package com.chrrissoft.simpletodolist.db

import androidx.room.Room
import com.chrrissoft.simpletodolist.SimpleTodoApp
import com.chrrissoft.simpletodolist.constants.General.packageName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SimpleTodoListAppDatabaseModule {
    @Provides
    fun provides(app: SimpleTodoApp): SimpleTodoListAppDatabase =
        Room.databaseBuilder(app, SimpleTodoListAppDatabase::class.java, packageName)
            .fallbackToDestructiveMigration()
            .build()
}
