package basics

fun main(){

    abstract class Person(name: String, val age: Int) {
        var name = name
            get() = "Name: $field"
            set(value) {
                field = value
            }
    }

    class Developer(name: String):Person(name, 20)

    fun test(){
        val d = Developer("Tom")
        val name = print(d.name)
    }

    test()
    alumno.nombre

}