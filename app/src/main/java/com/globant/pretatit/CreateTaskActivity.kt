package com.globant.pretatit.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.pretatit.R
import com.globant.pretatit.components.SimpleDropdown
import com.globant.pretatit.domain.model.TaskPriority
import com.globant.pretatit.presentation.theme.PretatitTheme
import com.globant.pretatit.presentation.viewmodel.CreateTaskViewModel

const val CREATE_TASK_RESULT = "CREATE_TASK_RESULT"

class CreateTaskActivity : ComponentActivity() {

    private val viewModel: CreateTaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PretatitTheme {
                // Colectăm starea din ViewModel
                val taskState by viewModel.taskState.collectAsState()

                Scaffold(
                    topBar = {
                        CreateListTopAppBar(
                            navAction = { finish() },
                            actionAction = {
                                // Trimitem task-ul final înapoi la ecranul principal
                                val result = Intent().putExtra(CREATE_TASK_RESULT, taskState)
                                setResult(Activity.RESULT_OK, result)
                                finish()
                            }
                        )
                    }
                ) { padding ->
                    ScreenContent(
                        modifier = Modifier.padding(padding),
                        task = taskState,
                        onTitleChange = { viewModel.updateTitle(it) },
                        onDescriptionChange = { viewModel.updateDescription(it) },
                        onPriorityChange = { viewModel.updatePriority(it) },
                        onCategoryChange = { viewModel.updateCategory(it) }
                    )
                }
            }
        }
    }
}

@Composable
private fun ScreenContent(
    modifier: Modifier,
    task: Task,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onPriorityChange: (String) -> Unit,
    onCategoryChange: (String) -> Unit
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Câmp pentru titlu
        Column {
            Text("Title", style = MaterialTheme.typography.titleMedium)
            OutlinedTextField(
                value = task.title,
                onValueChange = onTitleChange,
                label = { Text(stringResource(R.string.create_task_enter_task)) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Câmp pentru descriere
        Column {
            Text("Description", style = MaterialTheme.typography.titleMedium)
            OutlinedTextField(
                value = task.description,
                onValueChange = onDescriptionChange,
                label = { Text(stringResource(R.string.create_task_task_enter_description)) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Dropdown pentru prioritate
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Priority", style = MaterialTheme.typography.titleMedium)
            SimpleDropdown(
                items = TaskPriority.toListOfStrings(),
                selectedValue = task.taskPriority.name,
                onValueChange = onPriorityChange
            )
        }

        // Dropdown pentru categorie
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Category", style = MaterialTheme.typography.titleMedium)
            SimpleDropdown(
                items = listOf("General", "Work", "Personal", "Shopping"), // Lista de categorii
                selectedValue = task.category,
                onValueChange = onCategoryChange
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreateListTopAppBar(navAction: () -> Unit, actionAction: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(R.string.create_task_title)) },
        navigationIcon = {
            IconButton(onClick = navAction) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(onClick = actionAction) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Save Task"
                )
            }
        }
    )
}