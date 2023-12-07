package basics

class Extensions {

    fun String.happy():String{
        return "$this :)"
    }

}

fun main() {

    //Check nulls
    fun Any?.isNull() = this == null
    val age:Int? = null

    if(age.isNull()){
        println("Age es null")
    } else {
        println("Age no es null")
    }



}