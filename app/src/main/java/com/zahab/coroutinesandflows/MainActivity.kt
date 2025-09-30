package com.zahab.coroutinesandflows

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
import androidx.lifecycle.lifecycleScope
import com.zahab.coroutinesandflows.sections.compose_coroutines.CounterScreen
import com.zahab.coroutinesandflows.ui.theme.CoroutinesAndFlowsTheme
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        lifecycleScope.launch {
//            val timeinmillis = measureTimeMillis {
//            val innerjob1 = async {
//                delay(2000L)
//                println("Inner Job 1 Finished")
//
//            }.await()
//
//            val innerJob2 = async {
//                delay(1000L)
//                println("Inner Job 2 Finished")
//            }.await()
//            }
//
//            println("Both jobs took $timeinmillis time")
//        }


        setContent {
            CoroutinesAndFlowsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    CounterScreen()
                }
            }
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