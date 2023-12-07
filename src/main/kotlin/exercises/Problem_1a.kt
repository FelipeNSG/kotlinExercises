package exercises

/*
Exercise 1: Asynchronous Data Loading
Introduction: Practice using suspend functions for asynchronous operations.
Problem Statement: Create a function that asynchronously loads data from a mock database (use a simple list as the database). The function should be a suspend function.
*/

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class Db() {

    companion object {
        val dataBase: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    suspend fun loadData() {

        dataBase.map {
            delay(1000)
            println(it)
        }

    }

}



fun main() {

    val newBD = Db()
    println("Star main thread")

    runBlocking {

        println("Star runBlocking")

        newBD.loadData()

        println("End runBlocking")

    }

    println("End of de main thread")

}