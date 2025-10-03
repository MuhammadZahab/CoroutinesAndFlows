package com.zahab.coroutinesandflows.sections.coroutine_context

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

suspend fun queryDatabase() {

    val job = coroutineContext[Job]
    val dispatcher = coroutineContext[CoroutineDispatcher]
    val exceptionHandler = coroutineContext[CoroutineExceptionHandler]
    val coroutineName = coroutineContext[CoroutineName]


    CoroutineScope(Dispatchers.Main + CoroutineName("Parent Custom Coroutine") + SupervisorJob()).launch {   //this main coroutine will run on main thread and all childs as well, except those for which we will mention dispatcher separately
        println("custom CouroutineContext = ${coroutineContext[Job]}")
        println("custom CouroutineDispatcher = ${coroutineContext[CoroutineDispatcher]}")
        println("custom CouroutineExceptionHandler = ${coroutineContext[CoroutineExceptionHandler]}")
        println("custom CouroutineName = ${coroutineContext[CoroutineName]}")


        launch {
            launch(Dispatchers.IO) {   // this will run on IO threads

            }
        }
        launch {

        }
    }

    println("CouroutineContext = $job")
    println("CouroutineDispatcher = $dispatcher")
    println("CouroutineExceptionHandler = $exceptionHandler")
    println("CouroutineName = $coroutineName")


}