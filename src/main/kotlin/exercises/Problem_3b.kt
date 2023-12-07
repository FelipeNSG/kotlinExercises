package exercises

import kotlinx.coroutines.*

/*Exercise 6: Job Lifecycle Observing
Introduction: Monitoring job states (Active, Completing, Cancelled).
Problem Statement: Create a job and implement listeners to observe its lifecycle events like starting, completing, and cancellation.*/



fun main() {
    runBlocking {

        val firstThread = launch {
            println("firstThread execute")

        }
        firstThread.cancel()
        delay(1000)
        firstThread.invokeOnCompletion {
            println("thirdThread successful")


            if (firstThread.isCancelled){
                println("FirstThread is isCancelled")
            }

        }



         if (firstThread.isActive){
             println("FirstThread is active")
         }

        if (firstThread.isCompleted){
            println("FirstThread is Completed")
        }


    }
}
