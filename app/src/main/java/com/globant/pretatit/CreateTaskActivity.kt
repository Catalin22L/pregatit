package com.globant.pretatit
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.globant.pretatit.presentation.theme.PretatitTheme


class CreateTaskActivity : ComponentActivity() {

    // For a more complex screen, consider using a ViewModel:
    // private val viewModel: CreateTaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PretatitTheme {
                Scaffold(
                    topBar = {
                        CreateTaskScreenTopAppBar {
                            // In a ViewModel setup, you might call:
                            // viewModel.onNavigateBackTriggered()
                            // And then the ViewModel would handle the finish() or navigation event.
                            finish() // Finishes the current activity
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // Replace Greeting with your actual screen content
                    ScreenContent(
                        modifier = Modifier
                            .padding(innerPadding) // Apply padding from Scaffold
                            .fillMaxSize() // Ensure content area fills available space
                    )
                }
            }
        }
    }
}

/**
 * Composable function for the TopAppBar of the Create Task screen.
 *
 * @param onBackButtonClicked Lambda to be invoked when the back button is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreateTaskScreenTopAppBar(onBackButtonClicked: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(R.string.create_task_title)) },
        navigationIcon = {
            IconButton(onClick = {
                onBackButtonClicked()
                Log.d("CreateTaskActivity", "Back button pressed")
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.back_button_description)
                    // Ensure R.string.back_button_description exists in your strings.xml
                    // e.g., <string name="back_button_description">Navigate back</string>
                )
            }
        }
        // You can add 'actions' here if needed, e.g., a save button
        // actions = {
        //     IconButton(onClick = { /* Handle save action */ }) {
        //         Icon(imageVector = Icons.Filled.Save, contentDescription = "Save Task")
        //     }
        // }
    )
}

/**
 * Placeholder for your actual screen content.
 *
 * @param modifier Modifier to be applied to the content.
 */
@Composable
private fun ScreenContent(modifier: Modifier = Modifier) {
// Replace this Box with your actual UI for creating a task
// For example, TextFields for title, description,
}