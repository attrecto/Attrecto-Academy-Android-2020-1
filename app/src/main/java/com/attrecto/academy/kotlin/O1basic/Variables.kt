package com.attrecto.academy.kotlin.O1basic

fun main(args: Array<String>) {

    // Változók deklarásása

    // Létrehozhatjuk csak a típusával.
    var streetNumber: Int

    // vagy rögtön értéket is adhatunk neki
    var streetName: String = "Wesselényi u."

    // A Kotlin tipusos nyelv, a streetNumber ezek után csak egész típusú lehet.
    //streetNumber = "Hello"                // HIBA

    // Viszont nem kötelező kiírni a típust, ha a fordító ki tudja találni!
    // Nem kell feleslegesen kódot írni.
    var streetName2 = "Wesselényi u."       // String lesz ez is!
    var streetNumber2 = 10

    // Nem változtatható (immutable) változók (read only). Ahol lehet, ajánlott immutable változókat használni

    val zip = "9024"

    streetName = "Wesselényi utca"          // Ez működik
    //zip = "9025"                          // HIBA

    // Kotlin-ban minden objektum (nincs primitív típus mint javában), mindegyikhez tartozik egy osztály:
    val number: Long
    val myChar = 'A'

    // Néha segíteni kell a fordítónak hogy pontosan az a típus legyen amit szeretnénk.
    val myLong = 10L

    // Nincs semmilyen automatikus típus konvertálás, mint javában, ahol az int-et automatikusan long-ra konvertálta
    val myInt = 10
    val myLongAgain: Long = myInt.toLong()

    // String interpolation (beszúrás), nem kell "streetName " + streetName
    val streetNameMessage = "streetName : $streetName"

    // Működik metodusokra is.
    val streetNameLengthMessage = "streetName : ${streetName.length}"

    // 1. FELADAT (mindig a hello world)
    // Készíts egy name (immutable) változót, ami a saját nevedet kapja értékül, és
    // írd ki hogy "hello (a te neved)!" a println utasítással

    val name = "Balázs"
    println("Hello $name")
}