package com.chrrissoft.simpletodolist.di

import android.content.Context
import com.chrrissoft.simpletodolist.SimpleTodoApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SimpleTodoListAppModule {
    @Provides
    fun provides(@ApplicationContext ctx: Context): SimpleTodoApp = ctx as SimpleTodoApp
}
