package com.globant.pretatit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.globant.pretatit.domain.model.TaskPriority
import com.globant.pretatit.presentation.Task
import com.globant.pretatit.presentation.TaskPriority
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreateTaskViewModel : ViewModel() {

    private val _taskState = MutableStateFlow(
        Task(title = "", description = "", taskPriority = TaskPriority.NONE, category = "General")
    )
    val taskState = _taskState.asStateFlow()

    fun updateTitle(title: String) {
        _taskState.update { it.copy(title = title) }
    }

    fun updateDescription(description: String) {
        _taskState.update { it.copy(description = description) }
    }

    fun updatePriority(priorityName: String) {
        val priority = TaskPriority.getValueByName(priorityName)
        _taskState.update { it.copy(taskPriority = priority) }
    }

    fun updateCategory(category: String) {
        _taskState.update { it.copy(category = category) }
    }
}