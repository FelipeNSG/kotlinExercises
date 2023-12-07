package exercises

import kotlinx.coroutines.*
import javax.swing.text.StyledEditorKit.BoldAction

/*
introduction: Creating and managing custom coroutine scopes.
Problem Statement: Create a custom coroutine scope for a specific lifecycle, like a user session.
Solution Idea:
Define a coroutine scope using CoroutineScope and an appropriate dispatcher.
Launch coroutines in this scope and implement a mechanism to cancel all coroutines when the session ends.
*/
class UserRegister() {
    companion object {
        val usersList: List<String> = listOf("user1")
    }
}

val userList = UserRegister
lateinit var mySession: Job

fun main() {

    runBlocking {

        var accessConceded = false
        val login = CoroutineScope(Dispatchers.IO)
        login.launch {

            while (true) {
                println("Please enter you username: ")
                val validationUser = readln()
                if (validationUser in userList.usersList) {
                    println("Access conceded")
                    accessConceded = true
                    break
                } else {
                    println("Error Try again")
                }
            }
            login.cancel()

        }

        delay(6000)

        if (accessConceded) {

            val session = CoroutineScope(Dispatchers.IO)
            session.launch {
                while (true) {
                    println("\nThe session is running")
                    delay(4000)
                }
            }

            while (session.isActive) {
                session.launch {
                    print("Enter 1 to cancel the session: ")
                    val exit = readln().toInt()
                    if (exit == 1) {
                        session.cancel()
                        println("Session cancelled")
                    }
                }
                delay(5000)
            }
        }
    }
}







