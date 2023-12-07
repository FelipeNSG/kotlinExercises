package basics

import kotlin.reflect.KProperty

class InvoiceLine(val item: String, val price: Double, val quantity: Int) {
    val description: String by Description()
}

fun main() {
    val invoiceLine = InvoiceLine("Sandwich", 5.0, 1)
    println(invoiceLine.description)
}

class Description {
    operator fun getValue(thisRef: InvoiceLine, property: KProperty<*>): String {
        val total = thisRef.price * thisRef.quantity
        return buildString {
            append(thisRef.item)
            append("\n")
            append("$${thisRef.price}")
            append(" x ")
            append("${thisRef.quantity}")
            append(" = ")
            append("$$total")
        }
    }
}
