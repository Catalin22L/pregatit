package com.globant.pretatit.domain

import com.globant.pretatit.core.Result
import com.globant.pretatit.core.UseCase
import com.globant.pretatit.domain.repos.TaskRepository
import com.globant.pretatit.presentation.Task
import com.globant.pretatit.core.Result.Failure

interface GetAllTasksUseCase : UseCase<Unit, List<Task>>

class GetAllTasksUseCaseImpl(
    private val taskRepository: TaskRepository
) : GetAllTasksUseCase {
    override suspend fun invoke(params: Unit): Result<List<Task>, Failure> {
        return taskRepository.getAllTasks()
    }
}