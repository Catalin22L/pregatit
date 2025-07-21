package com.globant.pretatit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.pretatit.domain.repos.TaskRepository // <-- Verifică importul
import com.globant.pretatit.presentation.Task
import dagger.hilt.android.lifecycle.HiltViewModel // <-- Import nou
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // <-- Adnotare nouă
class TaskListViewModel @Inject constructor( // <-- Injectare prin constructor
    private val repository: TaskRepository
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getTasks()
                .catch { e -> e.printStackTrace() }
                .collect { taskList ->
                    _tasks.value = taskList.sortedWith(compareBy({ it.isDone }, { it.taskPriority }))
                }
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.saveTask(task)
        }
    }

    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            val taskToDelete = _tasks.value.find { it.id == taskId }
            taskToDelete?.let { repository.deleteTask(it) }
        }
    }

    fun toggleTaskDone(taskId: Int, isDone: Boolean) {
        viewModelScope.launch {
            val taskToUpdate = _tasks.value.find { it.id == taskId }
            taskToUpdate?.let { repository.updateTask(it.copy(isDone = isDone)) }
        }
    }
}