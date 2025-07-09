package com.globant.pretatit.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.pretatit.R
import com.globant.pretatit.presentation.theme.PretatitTheme
import timber.log.Timber

const val CREATE_TASK_RESULT = "create.task.result"

class TaskListActivity : ComponentActivity() {

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                Timber.d("${result.data?.getStringExtra(CREATE_TASK_RESULT)}")
            }
        }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PretatitTheme {
                Scaffold(
                    topBar = {
                        TaskListTopAppBar {
                            startCreateActivityForResult()
                        }
                    }) { paddingValue ->
                    // content

                    // Display a button if there are not tasks in the list
                    // When clicked the button will open CreateTaskActivity for result
                }

            }
        }
    }

    private fun startCreateActivityForResult() {
        val intent = Intent(
            this@TaskListActivity, CreateTaskActivity::class.java
        )
        launcher.launch(intent)
    }
    @Composable
    private fun ScreenContent(modifier: Modifier, createTaskButtonClick: () -> Unit) {
        Box(modifier) {
            if (taskList.isEmpty()) {
                ShowEmptyList {
                    createTaskButtonClick()
                }
            } else {
                ShowList()
            }
        }
    }

    @Composable
    private fun ShowEmptyList(createTaskButtonClick: () -> Unit) {
        Timber.d("ShowEmptyList()")
        Button(
            onClick = createTaskButtonClick,
            modifier = Modifier
                .padding(start = 25.dp, top = 25.dp),
        ) {
            Text(
                text = stringResource(R.string.create_task_title),
                fontSize = 20.sp
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TaskListTopAppBar(actionClick: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(R.string.your_task_list_title)) },
        actions = {
            IconButton(onClick = actionClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.task_list_create_task_description)
                )
            }
        })
}
