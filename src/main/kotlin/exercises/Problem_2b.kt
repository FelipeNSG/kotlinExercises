package exercises

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)

fun main() {

    runBlocking {

        val myScope = CoroutineScope(Dispatchers.IO)

        fun deferred() = myScope.async {
            println("Throwing exception from async")
            3 / 0
        }

        try {
            deferred().await()
        } catch (e: ArithmeticException) {
            println("Caught ArithmeticException")
        }
    }

    runBlocking {
        //
        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            println("Caught $exception")
        }
        val scope = CoroutineScope(Dispatchers.Default)

        fun myScope2() = scope.launch(exceptionHandler) {
            throw AssertionError("My Custom Assertion Error!")
        }

        myScope2().join()
    }
}
