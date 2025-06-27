package com.globant.pretatit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.pretatit.ui.theme.PretatitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PretatitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->




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