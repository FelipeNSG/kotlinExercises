package basics

/*
fun basics.basics.main (){
    fun genericsExample(value: String) {
        println(value)
        println("Type of value: ${value::class.java}")
    }
    genericsExample("Hola")
}*/


//Para saber el tipo de dato especifico de la funcion generica
/*
fun <T> genericsExample(classType: Class<T>, value: T) {
    println(value)
    println("Type of T: ${classType}")
}
fun basics.basics.main() {
    genericsExample<String>(String::class.java, "Learning Generics!")
    genericsExample<Int>(Int::class.java, 100)
}
*/



//código actualizado (usando tipos reificados)
/*inline fun <reified T> genericsExample(value: T) {
    println(value)
    println("Type of T: ${T::class.java}")
}
fun basics.basics.main() {
    genericsExample("Learning Generics!")
    genericsExample(100)
}*/

inline fun<reified T> showMessage(marks: Int): T {
    return when (T::class) {
        Int::class -> marks as T
        String::class -> "Congratulations! you scored more than 90%" as T
        else -> "Please enter valid type" as T
    }
}
fun main() {
    val intMarks: Int = showMessage(60) // returning integer value
    val stringMessage: String = showMessage(95) // returning string value
    println("Your marks: $intMarks \nMessage: $stringMessage")
}
