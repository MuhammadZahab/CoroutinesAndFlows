package com.zahab.coroutinesandflows.sections.coroutine_context

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

fun unconfinedDispatcher() {

    GlobalScope.launch {
        withContext(Dispatchers.Main) {
            println("Current thread = ${Thread.currentThread().name}")
            withContext(Dispatchers.Unconfined) {
                println("Current thread = ${Thread.currentThread().name}")
                withContext(Dispatchers.IO) {
                    println("Current thread = ${Thread.currentThread().name}")
                }
                println("Current thread = ${Thread.currentThread().name}")
            }
        }
    }
}
