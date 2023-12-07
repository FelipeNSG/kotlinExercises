package exercises

import kotlinx.coroutines.*

lateinit var mainJob: Job

fun main() {

    val customScope = CoroutineScope(Dispatchers.IO)
    customScope.launch {

        launch {

            launch {
                println("Thread father")

                val firstChild = launch {
                    while (true) {
                        delay(2100)
                        println("First Child")
                    }
                    println("This is the first child")
                }

                val secondChild = launch {
                    println("This is the second child")
                    while (true) {
                        delay(2200)
                        println("second Child")
                    }

                }

                mainJob = launch {
                    println("This is the third child")
                    while (true) {
                        delay(2300)
                        println("third Child")
                    }
                }


                /*if (firstChild.isActive) {
                println("Enter 1 for deactivate firstChild or 2 to continue: ")
                val option = readln().toInt()
                if (option == 1) {
                    firstChild.cancel()
                }
            }*/

                /*  if (secondChild.isActive) {
                println("Enter 1 for deactivate secondChild or 2 to continue: ")
                val option = readln().toInt()
                if (option == 1) {
                    secondChild.cancel()
                }
            }*/

                /* if (thirdChild.isActive) {
                println("Enter 1 for deactivate thirdChild or 2 to continue: ")
                val option = readln().toInt()
                if (option == 1) {
                    thirdChild.cancel()
                }
            }*/
            }

            while (true) {
                if (::mainJob.isInitialized) {
                    println("Enter 1 for deactivate fatherThread or 2 to continue: ")
                    val option = readln().toInt()
                    if (option == 1) {
                        mainJob.cancel()
                    }
                }
            }

        }

    }
    while (true){}
}