package com.globant.pretatit.data.repository

import com.globant.pretatit.core.Result // Asigură-te că importul pentru Result este corect
import com.globant.pretatit.data.datasource.mapper.toDomain
import com.globant.pretatit.data.datasource.mapper.toEntity
import com.globant.pretatit.core.Result.Failure
import com.globant.pretatit.data.datasource.local.db.PregatitDatabase
import com.globant.pretatit.data.datasource.remote.TaskApi
import com.globant.pretatit.domain.repos.TaskRepository
import com.globant.pretatit.presentation.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


// Am corectat constructorul pentru a injecta direct DAO-ul
class TaskRepositoryImpl @Inject constructor(
    private val taskDao: PregatitDatabase, // <-- INJECTĂM DAO, NU DATABASE
    create: TaskApi
) : TaskRepository {

    override fun getTasks(): Flow<List<Task>> {
        // Apelăm metoda direct pe DAO și mapăm rezultatul
        return taskDao.getAllTasks().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun saveTask(task: Task): Result<Unit, Failure> {
        return try {
            // Apelăm metoda de inserare pe DAO
            taskDao.insertTask(task.toEntity())
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(Result.Failure.DatabaseError)
        }
    }

    override suspend fun updateTask(task: Task): Result<Unit, Failure> {
        return try {
            taskDao.updateTask(task.toEntity())
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(Result.Failure.DatabaseError)
        }
    }

    override suspend fun deleteTask(task: Task): Result<Unit, Failure> {
        return try {
            taskDao.deleteTask(task.toEntity())
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(Result.Failure.DatabaseError)
        }
    }

    override fun getAllTasks(): Result<List<Task>, Failure> {
        TODO("Not yet implemented")
    }
}