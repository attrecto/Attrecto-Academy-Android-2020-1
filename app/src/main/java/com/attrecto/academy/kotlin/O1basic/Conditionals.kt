package com.attrecto.academy.kotlin.O1basic

fun main(args: Array<String>) {

    // Elágazás
    var myString = "Hello"
    if (myString == "") {
        println("Empty")
    } else {
        println("Not empty")
    }

    // Az elágazásnak van visszatérési értéke: az utolsó utasítás értékét veszi fel
    val result = if (myString == "") {
        "Empty"
    } else {
        "Not empty"
        0
    }

    println(result)

    // Ha különböző típusúak az utolsó értékek, akkor Any (bármilyen) típusú lesz a visszatérési érték

    // When van a java-s switch helyett, itt csak egyetlen egy ágat válasz (nem kell break)
    when (result) {
        "" -> println("It is an empty string")
        is String -> println("It is a string")
    }

    // És nem nagy meglepetésre, a when -nek ugyanúgy van visszatérési értéke
    val whenResult = when (result) {
        "" -> "It is an empty string"
        is String -> "It is a string"
        else -> "Not a string"
    }

    println(whenResult)

    // 3. FELADAT
    // Gondolj egy számra, tárold le egy number nevű változóba, és írd ki hogy "The number (szám amire gondoltál) is odd/even"

    val number = 0
    val numberResult = if (number % 2 == 0) "even" else "odd"

    println("The number $numberResult is $numberResult")
}
