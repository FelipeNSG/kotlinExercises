package basics

import kotlin.math.PI

fun main() {
//Let
   /* val name = "John".let {
        println(it) // 'John'
        // More uses of "John"...
        "Peter" // "name" value
    }

    println(name) // 'Peter'*/
   /*fun processNonNullString(str: String) {}
    val str: String? = "Hi"
    //processNonNullString(str)       // compilation error: str can be null
    val length = str?.let {
        println("let() called on $it")
        processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
        it.length
    }*/




//Also


   /* val listLet = listOf(1,2,3,4,5).let {
        println(it) // Muestra la lista original por pantalla
        it.asSequence().sortedDescending().sum()
    }
    println(listLet) // listLet no es una lista, es la suma de los números de la lista

    val listAlso = listOf(1,2,3,4,5).also {
        println(it) // Muestra la lista original por pantalla
        it.asSequence().sortedDescending().sum()
    }
    println(listAlso) // Seguiría siendo la lista original*/



   /* val numbers = mutableListOf("one", "two", "three")
    numbers

        .also { list ->
            println("The list elements before adding new one: $list")
        }
        .add("four")
        .also {
            println("The list elements before adding new one: $it")
        }
*/


//Apply
/*data class Circle (var radius: Int, var color: String)
    val circle = Circle(2, "red").also(::println)

    circle.apply {
        radius = 3
        color = "blue"
    }.also(::println)*/



//RUN

   /* data class Circle(var radius: Int, var color: String) {
        fun area() = PI * radius * radius
    }


        val totalArea = run {
            val circle = Circle(2, "red")
            val circle2 = Circle(3, "blue")
            circle.area() + circle2.area()
        }

        println(totalArea)*/

   data class MultiportService(var url: String, var port: Int) {
        fun prepareRequest(): String = "Default request"
        fun query(request: String): String = "Result for query '$request'"

    }

    val service = MultiportService("https://example.kotlinlang.org", 80)

    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port")
    }

    // the same code written with let() function:
    val letResult = service.let {
        it.port = 8080
        it.query(it.prepareRequest() + " to port ${it.port}")
    }
    println(result)
    println(letResult)
    println("${service.url} ${service.port}")




//With
    /*data class Circle(var radius: Int, var color: String)
    val circle = Circle(2, "red")
    with(circle) {
        println(radius)
        println(color)
    }*/




}