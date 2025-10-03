package com.zahab.coroutinesandflows.sections.coroutine_context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun withContextDemo() {

    println("Current Thread ${Thread.currentThread().name}")

    withContext(Dispatchers.Main) {
        println("Current Thread ${Thread.currentThread().name}")

        withContext(Dispatchers.Default) {
            println("Current Thread ${Thread.currentThread().name}")
        }
        withContext(Dispatchers.IO) {
            println("Current Thread ${Thread.currentThread().name}")
        }
    }
}