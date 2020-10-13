package com.attrecto.academy.kotlin.O2fun

import android.provider.ContactsContract

// A java-val ellentétben (ahol a függvényeknek egy-egy osztályban kellett lennie) itt lehet függvény osztály nélkül is.

// Egyszerű függvény, paraméter, és visszatérési érték nélkül
// Bár nem írtuk ki, de van visszatérési értéke: Unit (ami kb a java-s void)
fun hello() {
    println("Hello")
}

// De persze lehet más visszatérési értéke is, ez a függvény 4-et ad vissza
fun returnsAFour(): Int {
    return 4
}

// A függvényeknek lehet paramétere
fun takingString(name: String) {
    println(name)
}

// Lehet több paramétere is
fun sum(x: Int, y: Int): Int {
    return x + y
}

// Mivel a fordító kitalálja a visszatérési típus is, ezért lehet egyszerűsíteni rajta!
// Elhagyjuk a visszatérési típust, és a függvény body-ját is
fun sumSimple(x: Int, y: Int) = x + y

// A függvény paramétereknek lehet default értéke, nem kell overload-os függvényeket gyártani mint java-ban
// Ilyenkor ezek optional paraméterek, nem kell kitölteni őket.
fun sum(x: Int, y: Int, z: Int = 0) = x + y + z

// De mi van, ha a középső paraméter default?
fun printDetails(name : String, email: String = "", phone : String){
    println("Name: $name, email: $email, phone: $phone")
}

fun main() {
    hello()

    val value = returnsAFour()

    takingString("Some value")

    // Default érték
    sum(1, 2, 3)
    sum(1, 2)

    // Meg kell adni hogy melyik paraméterre gondoltunk (named parameters), ilyenkor a sorrend sem számít
    printDetails("Balázs", phone = "06 70  1234")
    printDetails(phone = "06 70  1234", name = "Balázs")
}