package basics

val listConsonants: List<String> =
    listOf("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "Ñ", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z")
val listVowels: List<String> = listOf("A", "E", "I", "O", "U")

fun String.countLetters() {
    var consonant = 0
    var wolves = 0

    for (i in this) {
        if (i.toString().uppercase() in listConsonants) {
            consonant++
        } else if (i.toString().uppercase() in listVowels) {
            wolves++
        }
    }

    if (consonant != 0 || wolves != 0) {
        print("The entered text contains $consonant consonants and $wolves vowels.")
    } else {
        println("The entered text does not contain vowels or consonants.")
    }
}

fun main() {
    val inputText: String = "Hello World"
    inputText.countLetters()
}

