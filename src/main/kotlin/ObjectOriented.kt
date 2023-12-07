/*

Exercise 2: Object-Oriented Design with Collections

Introduction: Design a small system to manage a library's book inventory.

Problem Statement: Create classes Book, Library, and LibraryManager. Book should have details like title and author.
Library should maintain a collection of books. LibraryManager should have functions to add books to the library,
search for a book by title, and list all books.

Solution Idea:

Implement the Book class with relevant properties.
Library should use a collection (like a list or a set) to store books.
LibraryManager should implement methods to interact with the Library's collection of books, including adding, searching, and listing books.

*/

const val OPTION_1 = 1
const val OPTION_2 = 2
const val OPTION_3 = 3



class Book(var title: String, val author: String)

open class Library(
    private val collectionBooks: MutableList<Book> = mutableListOf(
        Book(
            "Atomic Habits",
            "James Clear"
        )
    )
) {

    fun addBooks(title: String, author: String): Boolean {
        val book = Book(title, author)
        return collectionBooks.add(book)
    }

    fun searchABook(title: String): Book? {
        return getsBooks().firstOrNull() {
            it.title.equals(title)
        }
    }


    fun getsBooks(): List<Book> = collectionBooks

}


open class LibraryManager() : Library() {
    var option: Int = 0
    var exit = false
    var userLogs = Logger.instance

    init {
        while (!exit) {
            introduction()
            optionSelect()
            redirectToOptions()
            returnOrExitToMenu()
        }
    }



    fun setBooks() {
        userLogs.logMessage("Enter the name of the book: ")
        val title: String = readln()
        userLogs.logMessage("Enter the name of the author: ")
        val author: String = readln()
        addBooks(title, author)
        userLogs.logMessage("The book $title was added successfully")

    }


    //1. Ingresar las variable del titulo del libro
    //2. Hacer una busqueda del titulo del libro con la funcion firstOrNull que me devuelve el primer elemento que haga match con la busqueda si no devuelve null
    //3. debe comprobarse si se encontro o de volvio null la busqueda

    fun searchABookInList() {
        userLogs.logMessage("Enter the book you want to search: ")
        val title: String = readln()

        if (searchABook(title) is Book) {
            userLogs.logMessage("The book is available")
        } else {
            userLogs.logMessage("The book was not found")
        }
    }

    fun listingBooks(): Boolean {
        if (getsBooks().isNotEmpty()) {
            for (book in getsBooks()) {
                println("${getsBooks().indexOf(book) + 1}. ${book.title}")
            }
        } else {
            userLogs.logMessage("The book was not found")
        }
        return getsBooks().isNotEmpty()
    }

    fun introduction() {
        print(
            "Welcome to the library, the menu of available options will be shown below.\n" +
                    "1. Donate a book.\n" +
                    "2. Look for a book.\n" +
                    "3. Show a list of available books.\n" +
                    "Please enter the number of the option you wish to perform: "
        )
    }

    fun optionSelect(): Int {


        do {

            try {
                // Try to read an integer
                option = readln().toInt()
            } catch (e: NumberFormatException) {
                //catch exception if input is not an integer
                println("Please enter valid option.")
                continue  // Return to the beginning of the loop to request another input
            }

            // If we get here, the input is a valid integer
            break  // Exit the loop since we have a valid number

        } while (true)

        return option
    }

    fun redirectToOptions() {
        when (option) {
            OPTION_1 -> {
                setBooks()
            }

            OPTION_2 -> {
                searchABookInList()
            }

            OPTION_3 -> {
                listingBooks()
            }

            else -> {
                userLogs.logMessage("Incorrect option enter a valid option")
            }
        }
    }

    fun returnOrExitToMenu(): Boolean {
        while (true) {
            println("If you want to return and make a new option, press 1 or 2 to exit: ")

            optionSelect()
            when (option) {
                OPTION_1 -> {
                    exit = false
                    break
                }

                OPTION_2 -> {
                    exit = true
                    break
                }

                else -> {
                    exit = false
                    println("Invalid option choose a correct option")
                }
            }
        }
        return exit
    }


}

class Logger private constructor() {

    val saveMessages: MutableList<String> = mutableListOf()
    fun logMessage(message: String) {
        print(message)
        saveMessages.add(message)
    }

    fun getMessage(): List<String> = saveMessages
    fun printMessages() {
        println(getMessage())
    }


    companion object {

        val instance: Logger by lazy { Logger() }

    }

}


fun main() {
    LibraryManager()
    val userLogs = Logger.instance
    userLogs.printMessages()

}
