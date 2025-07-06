package com.globant.pretatit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.pretatit.ui.theme.PretatitTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        distinctStudents()
        capitalizeNames()
        longestWord()

        val numbers = listOf<Int>(1, 2, 2, 4, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0)
        filterEvenNumbers(numbers)
        removeDuplicates(numbers)

        setContent {
            PretatitTheme {
                Scaffold(
                    topBar = {
                        TopBar {
                            val intent = Intent(this, CreateTaskActivity::class.java)
                            startActivity(intent)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Greeting(
                        text = "Android",
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(start = 25.dp, top = 25.dp)
                    )
                }
            }
        }
    }

    private fun filterEvenNumbers(numbers: List<Int>) {
        val evenNo = numbers.filter { it % 2 == 0 }
        Log.d("MainActivity", evenNo.toString())
    }

    private fun removeDuplicates(numbers: List<Int>) {
        val distinct = numbers.distinct()
        Log.d("MainActivity", distinct.toString())
    }

    private fun distinctStudents() {
        val students = listOf<Student>(
            Student("Raluca", 10),
            Student("Ioana", 5),
            Student("Stefan", 5),
            Student("Eliza", 6),
            Student("Ana", 6),
            Student("Bogdan", 6)
        )

        val distinctStudents = students.distinctBy { it.grade }
        Log.d("MainActivity", distinctStudents.toString())

    }

    private fun capitalizeNames() {
        val names: List<String> = listOf("ana", "Cristina", "mariuS", "ALIN", "dan")

        val capList = names
            .map { it.lowercase() }
            .map { elem -> elem.replaceFirstChar { it.uppercase() } }

        Log.d("MainActivity", capList.toString())
    }

    private fun longestWord() {
        val list = listOf<String>("elephant", "dino", "dog", "cat", "goat")
//        val list = listOf<String>()

        val maxWord = list.maxByOrNull { it.length }

        maxWord?.let {
            Log.d("MainActivity", "maxWord: $maxWord")
        }

        val student = Student("Ioana", 7)
        student.grade = 5

        val student2 = Student("Dan")
                        .apply { this.grade = 9 }
        

        Log.d("MainActivity", "maxWord: is null")
    }
}

data class Student(val name: String, var grade: Int = 10)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(startActivity: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(R.string.your_task_list_title)) },
        actions = {
            IconButton(onClick = {
                startActivity()
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add new task"
                )
            }
        }
    )
}

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $text!",
        modifier = modifier,
        fontSize = 40.sp
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PretatitTheme {
        Greeting("Android")
    }
}