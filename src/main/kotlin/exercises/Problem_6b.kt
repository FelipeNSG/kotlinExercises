package exercises

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


sealed class Events {
    companion object {
        //crear 100 eventos del tipo message y notification delvolviendolos como flow luego el flow leer dentro del runBlocking y por cada evento que vaya leyendo pasarselos al sharedFlowMessage y sharedFlowNotification
        val sharedFlow:MutableSharedFlow<Events> = MutableSharedFlow()
        suspend fun generatedEvents() {
            for (i in 1..10) {
                delay(500)
                val theEvents = mutableListOf(Message, Notification).random()
                sharedFlow.emit(theEvents)
            }
        }
    }

    data object Message : Events() {

    }

    data object Notification : Events() {
    }
}

fun main() {
    val sharedFlowMessages = MutableSharedFlow<Events.Message>()
    val sharedFlowNotification = MutableSharedFlow<Events.Notification>()

    runBlocking {

        launch { sharedFlowMessages.collect { println("I received message $it") } }
        launch { sharedFlowNotification.collect { println("I received notification $it") } }

        launch {
          Events.generatedEvents()
        }

        launch {
        Events
            .sharedFlow
            .collect {

                when (it) {
                    is Events.Message -> sharedFlowMessages.emit(it)
                    is Events.Notification -> sharedFlowNotification.emit(it)

                }
            }
        }
    }
}
