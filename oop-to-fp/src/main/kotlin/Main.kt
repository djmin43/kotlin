package org.example

fun main() {
    println("Hello Functional World!")
    val sum = plusOne(3)
    println(sum)

    val intFun = ::plusOne

    fun plusTwo(a: Int) = intFun(intFun(a))

    println(plusTwo(3))
}

fun plusOne(a: Int) = a + 1

