package com.globant.pretatit.domain.repos
import com.globant.pretatit.core.Result.Failure
import com.globant.pretatit.core.Result
import com.globant.pretatit.presentation.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>
    suspend fun saveTask(task: Task): Result<Unit, Failure>
    suspend fun updateTask(task: Task): Result<Unit, Failure>
    suspend fun deleteTask(task: Task): Result<Unit, Failure>
}