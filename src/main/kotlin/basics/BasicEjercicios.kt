package basics

import java.io.InputStream
import java.util.Scanner

fun main(){
        //1. Exercise 1
        println("Hello World")

        //Exercise 2
        val num :Int = 12345
        val num2 :Byte = 123
        val num3 :Float = 3.1416f
        val num4 :Short = 5000
        val name :String = "Nery"
        val bol :Boolean = true

        println("\n $num\n $num2\n $num3\n $num4\n $name\n $bol\n")

        //Exercise 3
        val number1: Int = 10
        val number2: Int = 90

        val resultSum: Int = (number1 + number2)
        println("$resultSum \n")

        //2. Exercise 1
        //val immutable: String ="Hello"

        var immutable: String = "Hi"

        //Exercise 2

        val number: Int? = null
        val text: String? = null

        println("El valor de number es: $number")
        if(text == null){
            println("El valor de text es: null")
        }

        //Exercise 3
        val c: Float? = null
        var f: Float?

        fun fahrenheit(c:Float)
        {
            println("enter a celcious value: ")
            val scnn = Scanner(System.`in`)
            val newCelcious = scnn.nextFloat()
            f =(newCelcious * 9/5) + 32
            println("$newCelcious celcius son $f fahrenheit")
        }
        fahrenheit(0f)

        val fahrenheits: Float? = null
        val celcius: Float?
        fun fahrenheitsToCelcius (fahrenheits:Float){
            val celsiusResult = (fahrenheits - 32) * 5/9
            println("$fahrenheits fahrenheit son $celsiusResult celcius")
        }
        fahrenheitsToCelcius(32f)



    }




