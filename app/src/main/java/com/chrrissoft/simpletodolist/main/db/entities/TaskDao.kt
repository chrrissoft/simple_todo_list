package com.chrrissoft.simpletodolist.main.db.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.chrrissoft.simpletodolist.main.db.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun get(): Flow<List<Task>>

    @Query("SELECT * FROM tasks WHERE id = :id")
    fun get(id: String): Flow<Task>

    @Delete
    suspend fun delete(data: List<Task>) : Int

    @Insert(onConflict = REPLACE)
    suspend fun save(data: List<Task>)
}
