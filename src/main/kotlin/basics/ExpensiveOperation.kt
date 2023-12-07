package basics

/*
Introduction: Implement a custom delegate for caching the result of a computationally expensive operation.

Problem Statement: Create a class ExpensiveOperation that has a function compute that simulates a time-consuming operation
(e.g., a complex calculation).
Use Kotlin's delegation feature to cache the result of compute so that if the same input is used,
the cached result is returned instead of recomputing.
*/


import kotlin.reflect.KProperty


fun main() {
    val operation = ExpensiveOperation()
    println(operation.complexOperation(12.0, 5.0))
    println(operation.complexOperation(32.0, 5.0))
    print(operation.complexOperation(12.0, 5.0))
}

class ExpensiveOperation() {
    val mapCollectionForCaching: (Double, Double) -> Double by MapCollectionForCaching { p1, p2 ->
        (12345 * p1 * 232423 * p2 + p1 * 100) / 3.1416 * p1
    }

    fun complexOperation(num1d: Double, num2d: Double): Double {
        return mapCollectionForCaching(num1d, num2d)
    }

}

class MapCollectionForCaching(val callback: (Double, Double) -> Double) {
    private val map = mutableMapOf<String, Double>()

    operator fun getValue(thisRef: Any, property: KProperty<*>): (Double, Double) -> Double = { num1, num2 ->
        val key = (num1 + num2).toString()
        map.getOrPut(key) { callback(num1, num2) }
    }

}