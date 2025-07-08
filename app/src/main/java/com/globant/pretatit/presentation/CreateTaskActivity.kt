package com.globant.pretatit.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.res.stringResource
import com.globant.pretatit.R
import com.globant.pretatit.presentation.theme.PretatitTheme

class CreateTaskActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PretatitTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(R.string.create_task_title))
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    finish()
                                }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = stringResource(R.string.task_list_create_task_back_description)
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = {
                                    val result = Intent()
                                    result.putExtra(CREATE_TASK_RESULT, "This is a new task!")
                                    setResult(RESULT_OK, result)

                                    finish()
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Done,
                                        contentDescription = stringResource(R.string.task_list_save_task_description)
                                    )
                                }
                            }
                        )
                    }
                ) { padding ->
                    // content
                }
            }
        }
    }
}