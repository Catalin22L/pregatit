package com.globant.pretatit.domain.repos

import com.globant.pretatit.core.Result
import com.globant.pretatit.presentation.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    // Returnează un Flow pentru a observa lista de task-uri
    fun getTasks(): Flow<List<Task>>

    // Metode suspendate pentru operațiuni singulare
    suspend fun saveTask(task: Task): Result<Unit, Result.Failure>
    suspend fun updateTask(task: Task): Result<Unit, Result.Failure>
    suspend fun deleteTask(task: Task): Result<Unit, Result.Failure>
    fun getAllTasks(): Result<List<Task>, Result.Failure>
}