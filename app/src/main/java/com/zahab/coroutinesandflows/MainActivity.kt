package com.zahab.coroutinesandflows

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.zahab.coroutinesandflows.sections.compose_coroutines.ProfileScreen
import com.zahab.coroutinesandflows.sections.coroutine_context.queryDatabase
import com.zahab.coroutinesandflows.ui.theme.CoroutinesAndFlowsTheme
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // assignment1()

        lifecycleScope.launch {
            queryDatabase()
        }
        setContent {
            CoroutinesAndFlowsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    ProfileScreen()
                }
            }
        }
    }

    fun assignment1() {
        val mainThread = lifecycleScope.launch {

            launch {
                while (isActive) {
                    println("Coo")
                    delay(1000L)
                }
            }

            launch {
                while (isActive) {
                    println("Caw")

                    delay(2000L)
                }
            }

            launch {
                while (isActive) {
                    println("Chirp")
                    delay(3000L)
                }
            }
        }


        lifecycleScope.launch {
            delay(10000L)
            println("Cancelling all coroutines")
            mainThread.cancel()
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutinesAndFlowsTheme {
        Greeting("Android")
    }
}

