package basics

class Button() {

    fun  onClick(simulateClick: () -> Unit) {
        println("Inner Click")
        simulateClick()

    }

}

fun main() {

    val button = Button()
    println("Press Enter to simulate a button click: ")
    readln()
    // Similar OnClick with a lambda function
    button.onClick {
        // Code that runs when a button click is simulated

        println("basics.Button clicked!")
    }

    println("End of program")
}

