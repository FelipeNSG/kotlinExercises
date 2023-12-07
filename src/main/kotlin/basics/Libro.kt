package basics

class Libro(val isbn:Long) {

    init {
        options()
    }

    fun options() {
        print("\nChoose one of the following options\n 1. Add a new movie 2. Rate a movie ")
    }

}

fun main(){

    val book = Libro(1232421)
    print(book.isbn)



}