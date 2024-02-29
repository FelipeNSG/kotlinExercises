package exercises

interface SimulatedObject  {

    object Result: SimulatedObject
    fun simulationObject(a:Int, b:Int):Int {
       return a*b
    }
}

fun main() {
    val user = SimulatedObject.Result.simulationObject(5,6)
    println(user)
}

