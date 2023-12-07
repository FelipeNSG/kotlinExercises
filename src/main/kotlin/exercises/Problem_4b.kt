package exercises

import kotlinx.coroutines.*
import java.lang.Exception

/*
Problem Statement: Create nested coroutine scopes and understand how cancellation and exception handling propagate.
*/
private fun throwException() {
    throw ArithmeticException()

}

fun main() {

     /*runBlocking {
          CoroutineScope(Dispatchers.IO)
         launch {

             println("This is the father")

             val child = launch {

                 println("This is the child")

                 val grandchild = launch {
                     println("This is the grandchild ")
                     3/0

                 }
             }

         }
     }*/

    /*runBlocking {
        CoroutineScope(Dispatchers.IO)
        launch {

            println("This is the father")
            3/0
            val child = launch {

                println("This is the child")

                val grandchild = launch {
                    println("This is the grandchild ")
                }
            }
        }
    }*/



        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
            println("Caught $exception")
        }

        val coroutineScope = CoroutineScope( SupervisorJob()+exceptionHandler)
        coroutineScope.launch() {
          /* try {

           }catch (e:Exception){
               println(e)
           }*/
            3/0
           println("coroutine 1 started")
            delay(100)
            println("coroutine 1 failed")

            coroutineScope.launch() {
                println("coroutine 2 started")
                delay(100)
                println("coroutine 2 finalize")

            }
        }
    while (true){}

        /*coroutineScope.launch() {
            println("coroutine 2 started")
            delay(100)
            println("coroutine 2 finalize")
            throwException()

        }*/




//    runBlocking {
//        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
//            println("Caught $exception")
//        }
//
//        val coroutineScope = CoroutineScope(Dispatchers.IO + exceptionHandler)
//        launch {
//
//            println("This is the father")
//
//            val child = launch {
//
//                println("This is the child")
//
//                fun grandchild() = launch(exceptionHandler) {
//                    println("This is the grandchild ")
//
//
//                }
//            }
//        }
//    }

}