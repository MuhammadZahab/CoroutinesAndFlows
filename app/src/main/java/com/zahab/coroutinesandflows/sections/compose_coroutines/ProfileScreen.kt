package com.zahab.coroutinesandflows.sections.compose_coroutines

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var isSnackbarShowing by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerpadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerpadding),
            contentAlignment = Alignment.Center
        ) {
            // Centered Button
            Button(
                onClick = {
                    coroutineScope.launch {
                        isSnackbarShowing = true
                        snackbarHostState.showSnackbar("Hello from Snackbar!")
                        isSnackbarShowing = false
                    }


                },
            ) {
                Text(text = if (isSnackbarShowing) "Snackbar is showing" else "Snackbar is hidden")
            }
        }
    }
}