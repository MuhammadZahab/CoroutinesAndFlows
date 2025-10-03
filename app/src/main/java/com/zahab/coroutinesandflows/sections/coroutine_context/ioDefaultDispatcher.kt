package com.zahab.coroutinesandflows.sections.coroutine_context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis

suspend fun ioDefaultDispatcher() {
    var threads = hashMapOf<Long,String>()

    val job = GlobalScope.launch(Dispatchers.Default) {   //we can also add Dispatchers.IO.limitedParallelism(100), this will dedicate 100 threads for this process

        repeat(100) {
            launch {
                threads[Thread.currentThread().id] = Thread.currentThread().name
                //Thread.sleep(1000L)  // in this scenario IO Dispatcher is performing best

                (1..100_000).map {   // in this scenario Default dispatcher is performing the best
                    it * it
                }
            }
        }

    }

    val timeInMillis = measureTimeMillis {
        job.join()
    }
    println("No of Threads = ${threads.size} and time = $timeInMillis")

}