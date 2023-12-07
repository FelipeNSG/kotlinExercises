package basics

import java.time.Year


//Exercise 1

class Person (var name: String, var age: Int) {
    fun  greeting(){
        println("Hello ${name} with $age years old")
    }
    fun haveBirthday(){
        age++
        println("Your ager increased by one year is: $age \n")
    }
}

fun main (){
    //Exercise 1
    var person = Person("Juan", 18)
    person.greeting()
    person.haveBirthday()


    //Exercise 2
    var book = Book("The Little Prince", "Antoine de Saint-Exupéry", 1943)
    var book2 = Book("Atomic Habits","James Clear", 2018)
    var book3 = Book("Sherlock Holmes", "Arthur Conan Doyle",  1887)
    var book4 = Book ("Percy Jackson and the Olympians", " Rick Riordan", 2006)

    var books = listOf(book, book2, book3, book4)
    for(book in books){
        book.displayInfo()
    }

}


//Exercise 2

data class Book (var title: String, var author: String, var publicationYear: Int){

    fun displayInfo(){
        println("Title: $title, author: $author, Publication Year: $publicationYear")
    }
}