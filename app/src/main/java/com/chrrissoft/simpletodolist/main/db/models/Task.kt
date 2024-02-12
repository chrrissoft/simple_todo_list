package com.chrrissoft.simpletodolist.main.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "task") val task: String = "",
    @ColumnInfo(name = "complete") val complete: Boolean = false,
)
