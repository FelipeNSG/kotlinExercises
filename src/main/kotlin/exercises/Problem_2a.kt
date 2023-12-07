package exercises

import kotlinx.coroutines.*

/*
Exercise 3: Dispatcher Exploration
Introduction: Understanding different coroutine dispatchers.
Problem Statement: Create coroutines with different dispatchers (Default, IO, Main) and observe their behavior.
*/


fun log(message: String) {
    println("[${Thread.currentThread().name}] : $message")
}

@OptIn(DelicateCoroutinesApi::class)
fun main() {

    log("Star Thread.main")

        GlobalScope.launch(Dispatchers.Default) {
            var result = 0
            for (i in 1..10_000) {
                result = i * 10
            }
            log("Thread.Default result: $result")
        }

        GlobalScope.launch(Dispatchers.IO) {
            val mul = 3*546546
            log("Thread.IO $mul")

    }

    GlobalScope.launch(Dispatchers.Unconfined) {
        // perform network request to fetch data
        log(" Thread.Unconfined ${Db.dataBase}")
    }



    log("End Thread.main")
}