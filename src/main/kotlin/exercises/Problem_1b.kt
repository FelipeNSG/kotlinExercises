package exercises

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*Exercise 2: Data Processing Pipeline
Introduction: Combine multiple suspend functions for a data processing pipeline.
Problem Statement: Implement a pipeline where data is fetched, processed, and then saved. Each step should be a separate suspend function.
*/

class OperationsPipeline(private val dataBase: List<Int>) {


     suspend fun fetchData(): List<Int>  {
        delay(1000)
        val consulting = dataBase.map { it }
        println("fetch: $consulting")
        return consulting

    }

    suspend fun processData(data: List<Int>):List<Int> {
        val data1 =  data.map { it*2 }
        delay(1000)
        println("\nProcess Data: $data1 \n")
        return (data1)

    }

    suspend fun saveData(saveData: List<Int>) {
        delay(1000)
        println("Save data $saveData ")
    }

}

fun main() {

    runBlocking {
        val newOperations = OperationsPipeline(Db.dataBase)
        val fetch = newOperations.fetchData()
        val process =newOperations.processData(fetch)
         newOperations.saveData(process)

    }

}