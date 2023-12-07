package basics

const val choose_option_1 = 1
const val choose_option_2 = 2
const val choose_option_3 = 3

data class Movie(var name: String, val ratings: MutableList<Float> = mutableListOf()) {
    
    val rating: Float
         get() {
            if (ratings.isEmpty()) {
                return 0f
            }
            return ratings.average().toFloat()
        }
}   

val listOfMovies = mutableListOf<Movie>()
var loopToRepeatMenuOptions = true

fun showMenu() {
    println(
        "Menu\nThere are no movies currently added, Do you want to add a new movie?\nEnter the value 1 to add " +
                "a new movie: "
    )
}

fun enterUserOptionByKeyboard(): Int {
    var numberEntered: Int

    do {

        try {
            // Try to read an integer
            numberEntered = readln().toInt()
        } catch (e: NumberFormatException) {
            //catch exception if input is not an integer
            println("Please enter valid information.")
            continue  // Return to the beginning of the loop to request another input
        }

        // If we get here, the input is a valid integer
        break  // Exit the loop since we have a valid number

    } while (true)

    return numberEntered
}

fun enterTheNameOfTheNewMovieUsingTheKeyboardAndSaveItInTheListOfMovies() {
    var enterNameOfTheNewMovie = readln()
    var numberOfCharacters = enterNameOfTheNewMovie.length

    while (numberOfCharacters > 20) {
        print("Please enter a name with a maximum of 20 characters characters: ")
        enterNameOfTheNewMovie = readln()
        numberOfCharacters = enterNameOfTheNewMovie.length
    }
    val newMovie = Movie(enterNameOfTheNewMovie)
    listOfMovies.add(newMovie)
}

fun chooseOption1EnterMovieByKeyboard(option: Int) {

    while (option != choose_option_1) {
        println("invalid option please enter a correct value 1 indicated on the screen")
        val validation = enterUserOptionByKeyboard()
        if (validation == choose_option_1) {
            println("Enter the name of the movie:")
            enterTheNameOfTheNewMovieUsingTheKeyboardAndSaveItInTheListOfMovies()
            println("The new movie added: ${listOfMovies[listOfMovies.lastIndex].name} ")
            break
        }
    }

    if (option == choose_option_1) {
        println("Enter the name of the movie:")
        enterTheNameOfTheNewMovieUsingTheKeyboardAndSaveItInTheListOfMovies()
        println("The new movie added: ${listOfMovies[listOfMovies.lastIndex].name} ")
    }
}

fun showTheOptionsToAddAMovieOrNotOnTheScreen() {
    println(
        "\nWould you like to add a rating to this movie?\nEnter enter 1 to not do it " +
                " or " +
                "2 to add a new rating"
    )
}

fun enterRatingForTheMovie(): Float {
    var numberFloat: Float

    do {

        try {
            // Try to read an integer
            numberFloat = readln().toFloat()
        } catch (e: NumberFormatException) {
            //catch exception if input is not an integer
            println("Please enter a valid number.")
            continue  // Return to the beginning of the loop to request another input
        }

        // If we get here, the input is a valid integer
        break  // Exit the loop since we have a valid number

    } while (true)

    return numberFloat
}

fun movieRatingAddedToRatings() {
    var ratingAdd = enterRatingForTheMovie()

    // while (ratingAdd in 1F..10F) {
    while (0 < ratingAdd && ratingAdd >= 10) {
        println("The value is incorrect, please enter one within the range of 1 to 10 (integers with decimals are accepted): ")
        ratingAdd = enterRatingForTheMovie()
    }
    //listOfMovies.last().ratings
    listOfMovies[listOfMovies.lastIndex].ratings.add(ratingAdd)
}

fun addRatingToMovieOrNotDoIt(enterUserOptionByKeyboard: Int) {

    var enterValid = enterUserOptionByKeyboard
    while (enterValid != choose_option_1 && enterValid != choose_option_2) {
        println("invalid option please enter a correct value 1 or 2 indicated on the screen")
        enterValid = enterUserOptionByKeyboard()
    }

    if (enterValid == choose_option_2) {
        println("Please enter rating from 1 to 10: ")
        movieRatingAddedToRatings()
    } else {
        return
    }
}

fun showOptionsMenuWithAllAddedMovies() {
    println("Menu\n These are all the movies added")
    listOfMovies.forEachIndexed { index, movie ->
       // val counter = index + 1
        if (movie.ratings.isEmpty()) {
            println("${(index + 1)}. ${movie.name} with unrated movie}")
        } else {
            println("${(index + 1)}. ${movie.name} with a rating of ${movie.rating}")
        }
    }
    println(
        "\nEnter one of the following values if you want to perform one of the following actions\n" +
                "1. Add new movie, 2. Rate a movie, 3. to exit\n" +
                "Enter option: "
    )
}

fun showListOfListedMovies() {
    println("\nChoose movie number to rate\n")
    listOfMovies.forEachIndexed { index, movie ->
        if (movie.ratings.isEmpty()) {
            println("${(index + 1)}. ${movie.name} unrated movie\n")
        } else {
            println("${(index + 1)}. ${movie.name} with a rating of ${movie.rating}\n")
        }
    }
}
fun enterAMenuOptionByKeyboardAndExecuteTheOption(enterUserOptionByKeyboard: Int) {
    var validation = enterUserOptionByKeyboard
    while (validation != choose_option_1 && validation != choose_option_2 && validation != choose_option_3) {
        println("Incorrect value please enter a valid value")
        validation = enterUserOptionByKeyboard()
    }

    when (validation) {

        choose_option_1 -> {
            chooseOption1EnterMovieByKeyboard(validation)
            showOptionsMenuWithAllAddedMovies()
        }

        choose_option_2 -> {
            showListOfListedMovies()

            fun enterTheMovieNumberAndShowItsNameAndAverageRating() {
                println("Enter the number of movie:")
                var numberOfMovie = enterUserOptionByKeyboard()

                while (numberOfMovie> listOfMovies.size){
                    println("Invalid value enter a value from the list: ")
                    numberOfMovie = enterUserOptionByKeyboard()

                }
                val nameOfTheMovieWithTheNumberOfTheSelectedList = listOfMovies[numberOfMovie - 1].name
                val ratingsOfMoviesAddedToTheList = listOfMovies[numberOfMovie - 1].ratings
                var movieRatingAverageWithSelectedListNumber = listOfMovies[numberOfMovie - 1].rating

                if (listOfMovies[numberOfMovie - 1].ratings.isNotEmpty()) {
                    println(
                        "The selected movie is: $nameOfTheMovieWithTheNumberOfTheSelectedList " +
                                "with $movieRatingAverageWithSelectedListNumber " +
                                "of average rating\n" +
                                "Add a rating for movie: "
                    )

                } else {
                    println(
                        "The selected movie is: $nameOfTheMovieWithTheNumberOfTheSelectedList " +
                                "is not yet rated\n" +
                                "Add a rating for movie: "
                    )
                }

                movieRatingAddedToRatings()
                val length = ratingsOfMoviesAddedToTheList.size
                movieRatingAverageWithSelectedListNumber = listOfMovies[numberOfMovie - 1].rating
                println(
                    "The movie $nameOfTheMovieWithTheNumberOfTheSelectedList " +
                            "has an average rating $movieRatingAverageWithSelectedListNumber" +
                            " with a total $length ratings\n" +
                            "These are the ratings that the film has obtained: $ratingsOfMoviesAddedToTheList \n"
                )
            }
            enterTheMovieNumberAndShowItsNameAndAverageRating()
            showOptionsMenuWithAllAddedMovies()
        }

        choose_option_3 -> {
            loopToRepeatMenuOptions = false
            return
        }
    }
}
fun main() {
    showMenu()
    chooseOption1EnterMovieByKeyboard(enterUserOptionByKeyboard())
    showTheOptionsToAddAMovieOrNotOnTheScreen()
    addRatingToMovieOrNotDoIt(enterUserOptionByKeyboard())
    showOptionsMenuWithAllAddedMovies()

    while (loopToRepeatMenuOptions) {
        enterAMenuOptionByKeyboardAndExecuteTheOption(enterUserOptionByKeyboard())
    }
}