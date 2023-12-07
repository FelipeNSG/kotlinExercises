/*
const val basics.choose_option_1 = 1
const val basics.choose_option_2 = 2

data class basics.Movie (var name: String, val ratings: MutableList <Float> = mutableListOf() ){
    fun rating () {
        ratings.average().toFloat()
    }
}


val basics.getListOfMovies = mutableListOf<basics.Movie>()
var basics.getLoopToRepeatMenuOptions = true

fun basics.showMenu () {
    println("Menu\nThere are no movies currently added, Do you want to add a new movie?\nEnter the value 1 to add " +
            "a new movie: ")
}


fun basics.enterUserOptionByKeyboard (): Int {
    return readln().toInt()
}

fun basics.enterTheNameOfTheNewMovieUsingTheKeyboardAndSaveItInTheListOfMovies () {
    val enterNameOfTheNewMovie: String =readln()
    val newMovie = basics.Movie(enterNameOfTheNewMovie)
    basics.getListOfMovies.add(newMovie)
}


fun basics.chooseOption1EnterMovieByKeyboard (option:Int) {

    if (option == basics.choose_option_1) {
        println("Enter the name of the movie:")
        basics.enterTheNameOfTheNewMovieUsingTheKeyboardAndSaveItInTheListOfMovies()
        println("The new movie added: ${basics.getListOfMovies[basics.getListOfMovies.lastIndex].name} ")
    }else {
        basics.getLoopToRepeatMenuOptions = false
    }
}


fun basics.showTheOptionsToAddAMovieOrNotOnTheScreen () {
    println("\nWould you like to add a rating to this movie?\nEnter enter 1 to not do it " +
            " or " +
            "2 to add a new rating")
}

fun basics.enterRatingForTheMovie (): Float {
    return readln().toFloat ()
}

fun basics.movieRatingAddedToRatings () {

    basics.getListOfMovies[basics.getListOfMovies.lastIndex].ratings.add(basics.enterRatingForTheMovie())
}

fun basics.addRatingToMovieOrNotDoIt (basics.enterUserOptionByKeyboard: Int){

    if (basics.enterUserOptionByKeyboard == basics.choose_option_2) {
        println("Please enter rating: ")
        basics.movieRatingAddedToRatings ()
    } else {
        return
    }
}

fun basics.showOptionsMenuWithAllAddedMovies (){
    println("Menu\n These are all the movies added")
    basics.getListOfMovies.forEachIndexed { index, movie ->
        if (movie.ratings.isEmpty())  {
            println("${index}. ${movie.name} with unrated movie}")
        } else {
            println("$index. ${movie.name} with a rating of ${movie.rating()}")
        }
    }
    println("Enter one of the following values if you want to perform one of the following actions\n" +
            "1. Add new movie, 2. Rate a movie, 3. to exit\n" +
            "Enter option: ")
}

fun basics.showListOfListedMovies () {
    println("\nChoose movie number to rate\n")
    basics.getListOfMovies.forEachIndexed { index, movie ->
        if (movie.ratings.isEmpty()) {
            println("${index}. ${movie.name} unrated movie\n")
        } else {
            println("${index}. ${movie.name} with a rating of ${movie.rating()}\n")
        }
    }
}

val nameOfTheMovieWithTheNumberOfTheSelectedList = basics.getListOfMovies[basics.enterUserOptionByKeyboard () -1].name
val ratingsOfMoviesAddedToTheList = basics.getListOfMovies[basics.enterUserOptionByKeyboard ()-1].ratings
val movieRatingAverageWithSelectedListNumber = basics.getListOfMovies[basics.enterUserOptionByKeyboard ()-1].rating()

fun enterTheMovieNumberAndShowItsNameAndAverageRating () {
    println("Enter the number of movie:")
    basics.enterUserOptionByKeyboard()
    println(
        "The selected movie is: $nameOfTheMovieWithTheNumberOfTheSelectedList " +
                "with $movieRatingAverageWithSelectedListNumber " +
                "of average rating\n" +
                "Add a rating for movie: "
    )
}

fun addRatingToAMovieAndShowYourAverageAndAllYourPreviousRatings(){

    basics.movieRatingAddedToRatings ()
    val length = ratingsOfMoviesAddedToTheList.size
    println("The movie $nameOfTheMovieWithTheNumberOfTheSelectedList " +
            "has an average rating $movieRatingAverageWithSelectedListNumber" +
            " with a total $length ratings\n" +
            "These are the ratings that the film has obtained: $ratingsOfMoviesAddedToTheList \n")
}
fun enterAMenuOptionByKeyboardAndExecuteTheOption (basics.enterUserOptionByKeyboard: Int) {

    when (basics.enterUserOptionByKeyboard ) {
        basics.choose_option_1 -> {
            basics.chooseOption1EnterMovieByKeyboard(basics.enterUserOptionByKeyboard)
            enterAMenuOptionByKeyboardAndExecuteTheOption(basics.enterUserOptionByKeyboard())
        }

        basics.choose_option_2 -> {

            basics.showListOfListedMovies()
            enterTheMovieNumberAndShowItsNameAndAverageRating ()
            basics.enterRatingForTheMovie ()
            addRatingToAMovieAndShowYourAverageAndAllYourPreviousRatings()
        }
        else -> {
            basics.getLoopToRepeatMenuOptions = false
            return  }
    }

}

fun basics.basics.main(args: Array<String>) {
    //Menu
     basics.showMenu()
    println("Enter the name of the movie:")
//    basics.chooseOption1EnterMovieByKeyboard (basics.enterUserOptionByKeyboard())
//    basics.showTheOptionsToAddAMovieOrNotOnTheScreen ()
//    basics.addRatingToMovieOrNotDoIt (basics.enterUserOptionByKeyboard())
//    basics.showOptionsMenuWithAllAddedMovies ()
//    enterAMenuOptionByKeyboardAndExecuteTheOption(basics.enterUserOptionByKeyboard())
//    while (basics.getLoopToRepeatMenuOptions){
//        enterAMenuOptionByKeyboardAndExecuteTheOption(basics.enterUserOptionByKeyboard())
//    }
}*/


































