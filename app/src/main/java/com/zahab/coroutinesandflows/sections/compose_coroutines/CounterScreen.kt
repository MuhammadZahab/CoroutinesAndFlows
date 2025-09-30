package com.zahab.coroutinesandflows.sections.compose_coroutines

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun CounterScreen(
    modifier: Modifier = Modifier
) {
    var counter by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(counter) {
        delay(1000L)
        println("Launched effect called")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Button(modifier = Modifier.wrapContentSize(), onClick = {
            counter++
        }) {
            Text(
                text = "Counter is : $counter"
            )
        }

    }
}