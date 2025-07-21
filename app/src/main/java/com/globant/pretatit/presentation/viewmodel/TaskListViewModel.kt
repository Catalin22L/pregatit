package com.globant.pretatit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.pretatit.domain.TaskRepository
import com.globant.pretatit.domain.repos.TaskRepository
import com.globant.pretatit.presentation.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // Asigură-te că folosești Hilt pentru a injecta repository-ul
class TaskListViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    // Starea care va fi expusă către UI
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    init {
        // La inițializare, începem să colectăm datele din repository
        viewModelScope.launch {
            repository.getTasks()
                .catch { e ->
                    // Aici poți gestiona erorile, de ex. afișând un mesaj
                    e.printStackTrace()
                }
                .collect { taskList ->
                    // Când primim o listă nouă, o sortăm și actualizăm starea
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
            // Găsim task-ul după ID pentru a-l putea șterge
            val taskToDelete = _tasks.value.find { it.id == taskId }
            taskToDelete?.let {
                repository.deleteTask(it)
            }
        }
    }

    fun toggleTaskDone(taskId: Int, isDone: Boolean) {
        viewModelScope.launch {
            val taskToUpdate = _tasks.value.find { it.id == taskId }
            taskToUpdate?.let {
                repository.updateTask(it.copy(isDone = isDone))
            }
        }
    }
}