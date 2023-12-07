package exercises

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*Introduction: Use StateFlow for managing and observing UI state changes.
Problem Statement: Implement a UI state manager using StateFlow that emits states like loading, success, and error.*/

var stateInitial = MutableStateFlow(0) //message
var stateUI: StateFlow<Int> = stateInitial

fun events() {
    when (stateUI.value) {
        0 -> println("Data login")
        1 -> println("Data process")
        2 -> println("Data success")
        3 -> println("Error")

    }
}

fun main() {

  runBlocking {

    val newScope = CoroutineScope(Dispatchers.IO)
        newScope.launch {
            for (i in 1..3) {
                delay(3000)
                stateInitial.value = (1..3).random()
            }
        }
        // Collect values from stateUI
      events()
      newScope.launch {
            stateUI.collect{
                println("Collector 1 received: ")
            }
        }


      while (true){
          readln()
          newScope.cancel()
          break
      }
    }
}