/*
package basics

var array  = IntArray(10){it}
var suma = 0

fun basics.main(){

    fun recorrerArreglo( send: (Int) -> Boolean) {
        for (i in array) {
           val result = send(i)
            println("Es un numero par: $result number:$i")
        }
    }

 recorrerArreglo() {
        suma += it
     suma % 2 == 0
    }
    print("$suma")
}
*/


var array = IntArray(10) { it }
var suma = 0

fun main() {

    fun recorrerArreglo(arr: IntArray): Int {
        for (i in arr) {
            fun funcion2(send: Int){
                val a = send
                suma += send
            }
            funcion2(i)
        }
        return suma
    }


    println("La suma de los elementos del array es: ${recorrerArreglo(array)}")
}