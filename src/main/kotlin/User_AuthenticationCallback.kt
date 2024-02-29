
fun main() {
//Exercise 1: User Authentication Callback
    fun authenticateUser(username: String, password: Int, callback: (Boolean) -> Unit) {
        val defaultName = "Hello"
        val defaultPassword = 1234


        val name = defaultName == username
        val pass = defaultPassword == password

        callback(name && pass)

    }

    authenticateUser("Hello", 1234, ) { isUserAuthenticated ->
        if (isUserAuthenticated) {
            println("Access success")
        } else {
            println("Access failure ")
        }
    }

//Exercise 2: List Transformation with Lambdas

    //Exercise 2: List Transformation with Lambdas
fun transformList(listOfStrings: List<String>, listUppercase: (String) -> String): List<String> {
    val newListOfString: MutableList<String> = mutableListOf()
    for (element in listOfStrings) {
        val result = listUppercase(element)
        newListOfString.add(result)
    }

    return newListOfString
}

fun transformList2(listOfStrings: List<String>, listUppercase: (String) -> String): List<String> {
    return listOfStrings.map(listUppercase)
}


    val resulList = transformList2(listOf("felipe", "nery", "sanchez")) { str ->
        str.plus("_")

    }
    println(resulList)
}



