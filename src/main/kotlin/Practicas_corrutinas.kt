import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun log(message: String) {
    println("[${Thread.currentThread().name}] : $message")
}

fun log(character: Char) {
    print("$character")
}

fun main() {
    log("Start")

    runBlocking {
        val job = launch {

            val childJob = launch {
                repeat(3) {
                    log("Child rep #$it : I'm active")
                    delay(1000)
                }

                log("Child : I'm finishing.")
            }

            delay(100)
            while(childJob.isActive) {
                log("Launch : I'm active")
                delay(1000)
            }

            log("Launch : I'm finishing.")
        }

        delay(200)
        while(job.isActive) {
            log("RunBlocking : Job is active")
            delay(1000)
        }

        if(job.isCancelled) {
            log("RunBlocking : Job is cancelled")
        }

        if(job.isCompleted) {
            log("RunBlocking : Job is completed")
        }
    }

    log("End")
}