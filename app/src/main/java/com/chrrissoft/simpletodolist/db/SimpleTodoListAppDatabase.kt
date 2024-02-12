package com.chrrissoft.simpletodolist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chrrissoft.simpletodolist.main.db.entities.TaskDao
import com.chrrissoft.simpletodolist.main.db.models.Task

@Database(version = 1, entities = [Task::class])
abstract class SimpleTodoListAppDatabase : RoomDatabase() {
    abstract val tasksDao: TaskDao
}
