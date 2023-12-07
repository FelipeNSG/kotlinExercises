package basics

 abstract  class Estudiante( var nombre: String){
    fun hello(){
        print("Hello ${nombre}")
    }
}

class Alumno(nombre: String): Estudiante(nombre){
    fun asistencia(){

    }
}
var alumno: Alumno = Alumno("Nery")
var alumno2: Estudiante = Alumno("Nery")

fun main(){
    alumno.hello()
    makeSound(Audi())
}

fun makeSound(car: Car) {

    if(car is Bmw){
        println("Es un Bmw")
        car.t()
    }

}

abstract class Car

class Bmw: Car() {
    fun t(){}
}
class Audi: Car()

