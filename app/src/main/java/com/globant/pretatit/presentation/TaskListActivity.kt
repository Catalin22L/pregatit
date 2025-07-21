@file:Suppress("DEPRECATION")

package com.globant.pretatit.presentation

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.globant.pretatit.presentation.theme.PretatitTheme
import com.globant.pretatit.presentation.viewmodel.TaskListViewModel

class TaskListActivity : ComponentActivity() {

    private val viewModel: TaskListViewModel by viewModels()



    @AndroidEntryPoint // <-- ADAUGĂ ACEASTĂ ADNOTARE
    class TaskListActivity : ComponentActivity() {
        private val createTaskLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // FOLOSEȘTE ACEST BLOC NOU ȘI SIGUR
                val task = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    // Metoda nouă și sigură pentru Parcelable pe Android 13+
                    result.data?.getParcelableExtra(CREATE_TASK_RESULT, Task::class.java)
                } else {
                    // Metoda veche (deprecated) pentru compatibilitate
                    @Suppress("DEPRECATION")
                    (result.data?.getParcelableExtra(CREATE_TASK_RESULT))
                }

                task?.let {
                    viewModel.addTask(it)
                }
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                PretatitTheme {
                    // Colectăm lista de task-uri din ViewModel
                    val tasks by viewModel.tasks.collectAsState()

                    Scaffold(
                        topBar = { TopBar() },
                        floatingActionButton = {
                            FloatingActionButton(onClick = {
                                createTaskLauncher.launch(
                                    Intent(
                                        this,
                                        CreateTaskActivity::class.java
                                    )
                                )
                            }) {
                                Icon(Icons.Default.Add, contentDescription = "Add Task")
                            }
                        }
                    ) { padding ->
                        TaskListScreen(
                            modifier = Modifier.padding(padding),
                            tasks = tasks,
                            onTaskCheckedChange = { task, isChecked ->
                                viewModel.toggleTaskDone(task.id, isChecked)
                            },
                            onDeleteTask = { task ->
                                viewModel.deleteTask(task.id)
                            }
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun TaskListScreen(
        modifier: Modifier,
        tasks: List<Task>,
        onTaskCheckedChange: (Task, Boolean) -> Unit,
        onDeleteTask: (Task) -> Unit
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks, key = { it.id }) { task ->
                TaskItem(
                    task = task,
                    onCheckedChange = { isChecked -> onTaskCheckedChange(task, isChecked) },
                    onDelete = { onDeleteTask(task) }
                )
            }
        }
    }

    @Composable
    fun TaskItem(
        task: Task,
        onCheckedChange: (Boolean) -> Unit,
        onDelete: () -> Unit
    ) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = task.isDone,
                    onCheckedChange = onCheckedChange
                )
                Spacer(Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = task.title,
                        textDecoration = if (task.isDone) TextDecoration.LineThrough else null
                    )
                    Text(
                        text = task.description,
                        style = MaterialTheme.typography.bodySmall,
                        textDecoration = if (task.isDone) TextDecoration.LineThrough else null
                    )
                }
                Spacer(Modifier.width(16.dp))
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete Task")
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar() {
        TopAppBar(title = { Text("To-Do List") })
    }

}