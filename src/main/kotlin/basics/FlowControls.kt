package basics

import basics.Session.Companion.MINIMUM_AGE_TO_ENTER_TO_THE_PLACE

fun main() {
    val flowControls = FlowControls("")
    //flowControls.ifExpression()
    //flowControls.forLoop()
    //flowControls.whileLoop()
    flowControls.whenExpression()
}

class Session {
    init {
        println("the session was initialized")
    }

    companion object {
        const val MINIMUM_AGE_TO_ENTER_TO_THE_PLACE = 19
    }

    fun logSessionToFirebase() {
        println("the session was initialized, sending to firebase")
    }
}
class FlowControls() {

    var session: Session? = null

    init {
        println("I am in the init block")
        session = Session()
    }

    constructor(name: String) : this() {
        println("I am in the constructor")
        session?.logSessionToFirebase()
    }

    fun ifExpression() {

        val age = 40


        val isOlder: Boolean = if (age >18) true else false

        val isTall = MINIMUM_AGE_TO_ENTER_TO_THE_PLACE > 1.80
        val isLessThan40 = age < MINIMUM_AGE_TO_ENTER_TO_THE_PLACE

        if (isOlder && isTall) {
            println("you are in ")
        }  else if (isLessThan40) {
            println("second else if ")
        } else {
            return
        }

        if (age <= 40) {
            println("first else if ")
        }

        if (age < 40) {
            println("you are passed the second filter")
        } else {
            return
        }

        //

        //

    }

    fun forLoop() {

        val names = listOf("name 1", "name 2", "name 3")

        for (name in names) {
            //println(name)
        }

        val range = 4..40

        for (name in range) {
            //println(name)
        }

        for (name in range step 4) {
            //println(name)
        }

        for (numbers in 100 downTo 1 step 4) {
           // println(numbers)
        }

        for (number in 1 until 10) {
            println(number)
        }

    }

    fun whileLoop() {

        var counter = 0

        while (counter < 10) {
            // print
            counter++
            println("while: $counter")
        }

        var counter2 = 0
        do {
            counter2++
            println("doWhile: $counter2")
        } while (counter2 < 10)



    }

    fun validateAge(age: Int) : Boolean {
        return age >= 18
    }

    fun whenExpression() {

        val age = 19

        val isOlder: Boolean = when (age) {
            18,19,20-> {
                println("i am in")
                true
            }
            19-> {
                println("i am in 19")
                false
            }
            20-> {
                println("i am in 20")
                true
            }
            else -> {
                false
            }
        }

        val enumType: DaysOfTheWeek = DaysOfTheWeek.NONE

        when (enumType) {
            DaysOfTheWeek.MONDAY -> {

            }
            DaysOfTheWeek.TUESDAY -> {

            }

            DaysOfTheWeek.WEDNESDAY -> TODO()
            DaysOfTheWeek.THURSDAY -> TODO()
            DaysOfTheWeek.FRIDAY -> TODO()
            DaysOfTheWeek.SATURDAY -> TODO()
            DaysOfTheWeek.SUNDAY -> TODO()
            else -> {

            }
        }

       /* val day = getDay()
        val dayEnum: DaysOfTheWeek
        if (day == DaysOfTheWeek.TUESDAY.name){
           dayEnum = DaysOfTheWeek.MONDAY
        }*/

    }

    enum class DaysOfTheWeek(name: String) {
        MONDAY("lunes"),
        TUESDAY("martes"),
        WEDNESDAY("miercoles"),
        THURSDAY(""),
        FRIDAY(""),
        SATURDAY(""),
        SUNDAY(""),
        NONE("")
    }


}