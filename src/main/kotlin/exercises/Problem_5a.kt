package exercises

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
/*

Introduction: Practice transforming and combining flows.
Problem Statement: Create two separate flows and apply transformation operations like map and filter. Then, combine these flows using zip or combine.
*/
fun makeFlow() = flow {
    for (i in (1..8)) {
        emit(i)
    }
}
val list: Flow<String> = listOf("a", "b", "c", "d", "e").asFlow()

fun main() {

    runBlocking {
        val flow = makeFlow()
            .filter { it % 2 == 0 }
            .map { it * 2 }

        val flow2 = list.map { it.uppercase() }

        flow.zip(flow2) { a, n ->
            "$a -> $n"
        }.collect {
            println(it)
        }

        println("\n")

        flow.combine(flow2) { a, n ->
            "$a -> $n"
        }.collect{
            println(it)
        }
    }
}