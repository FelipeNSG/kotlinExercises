import java.lang.Exception
import java.util.Timer

const val _MYCONST = 1
fun main(args: Array<String>) {
    /*int x =
    Integer y = 9*/
    //
    val mByte: Byte = 17
    var age = Int.MIN_VALUE
    var mByte2 = 12
    var mByteVar = 140_000_88_99L

    val mShort = 1223
    val mShort2: Short = 32767

    val aChar: Char = '\uFF00'
    val name = "Enrique"

    greeting(name, age)
    // mutable
    // non mutable

    // ==
    // <=
    // >=
    // ===
    // !
    // !=
    // ||
    // &&

    //load profile(

    // cast
    // type check
    // logical operator
    // string templates
    // String.format()
    // Data types, Int, Double, Boolean, Char etc...
    // arrays and lists
    // camel case
    // trust sources -> DB
    // val || var
    // inferencia del tipo de dato
    // tipos concretos y primitivos
    // chars caracteres especiales '\n


    val persons = Array(10, { 2 })
    val persons2 = mutableListOf(1, 2, 3)

    persons.plus(4)
    persons2.add(4)
    //println("size persons2: ${persons2.size}")
    //println("size persons2: ${persons2.size}")


    var s: Any = "name"
    //println( s  )

    //println( ( (s is String) )  )


    if (s is String) {
        //print(s.length)
    }

}

fun greeting(name: String, age: Int) {

    val s = "abc"
    println("hello $name")
    //
    // "hello" + name + "welcome to inno tech labs, you are age is"

    val calculadora = Calculadora()
    calculadora.sumar(67, 1, false)
    calculadora.sumar(1, 1, false)
    calculadora.restar(1)

    val person = SalesPerson("Enrique", "")
    //val personClonable = person.copy(name = "Maria")
    println(person)
}

open class Calculadora {


    fun sumar(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun sumar(num1: Double, num2: Double): Int {
        return 0
    }

    fun sumar(num1: Int, num2: Int, bool: Boolean) {
        //
        println("antes del numero 67")
        //

        //
        if (num1 == 67) {
            println("no se permite el numero 67")
            return
        }
        //

        //
        println("despues del return")
        //

    }

    fun sumar(num2: Int) {

        if (num2 == 0) return

        if (true) {

        } else if (true) {

        } else {

        }

        val salesPerson = SalesPerson("")

        salesPerson.name = "enrique"
        println(salesPerson.name)
    }


    fun restar(num1: Int, num2: Int = 1) = num1 - num2

}

open class X() : Calculadora() {

    fun ad() {

    }

    fun adsadsjkladsjkl() {

    }

}


//good to know delegates
class Person(val age: Int) : X(), Car by Bmw() {

    fun asd() {
        makeSound()
    }

}

data class SalesPerson(var name: String, var person: String? = null) {

    constructor(name: String, person: String?, age: Int) : this(name, person) {
        remoteLogger(name)
    }

    constructor(name: String, person: String?, age: Int, test: String) : this(name, person)

    var client: String = name
        get() = field.plus("is a client")
        set(value) {
            field = value.plus(", ")
        }


    private fun remoteLogger(name: String) {
        // remoteLogger.send("$name is trying to buy something")
    }

    /* override fun toString(): String {
         return "name: $name, person: $person"
     }*/


}

class Customer(name: String) /*: SalesPerson(name) {

    //val name: String = name

    fun greeting() = print("Hello $name")

}*/


interface AnotherX {

}

interface Car {

    val brand: String

    fun makeSound()

    fun run()

    fun startEngine()

}


open class Bmw() : Car {

    override val brand: String
        get() = "bmw"

    override fun makeSound() {

    }

    override fun run() {
        TODO("Not yet implemented")
    }

    override fun startEngine() {
        print("key")
    }

}

class Audi() : Car {
    override val brand: String
        get() = "Audi"

    override fun makeSound() {
        TODO("Not yet implemented")
    }

    override fun run() {
        TODO("Not yet implemented")
    }

    override fun startEngine() {
        print("button")
    }

}