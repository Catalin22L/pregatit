package com.globant.pretatit.data.database

import androidx.room.*
import com.globant.pretatit.data.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    // Returnează un Flow pentru a observa schimbările în timp real
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Delete
    suspend fun deleteTask(task: TaskEntity)
}