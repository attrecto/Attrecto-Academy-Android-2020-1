package com.attrecto.academy.kotlin.O3classes

import java.util.*

// Osztályokat a class kulcsszóval készíthetek, a nagyon egyszerű osztályhoz ennyi pont elég is
class Simple

class CustomerOld {
    // Property-ket pont úgy deklarálunk, mint változókat
    // Ezek property-k, és nem field-ek!! (azaz van setter-ül, getter-ük, amiket felülírhatunk)
    var id = 0
    var name: String = ""
}

// Mindegyik property-nek van alapértelemezett értéke, de mi van ha nem akarunk ilyet?
// Lehetne a konstruktorba megadni majd beállítani mint Java-ban, de az nem annyira elegáns, helyette a property-ket deklarálhatjuk a konstruktorba
// Fontos, hogy ott van előtte a var/val, e nélkül csak konstruktor paraméterek
class Customer(
    val id: Int,
    // Mit a függvények paramétereinál itt is lehet alapértelmezett értéke
    var name: String = ""
) {

    // A létrehozásnál még lefut az init blokk is
    init {
        name = name.toUpperCase(Locale.getDefault())
    }

    // Tudunk secondary konstruktor is készíteni, de ennek mindig meg kell hívnia a primary konstruktort
    constructor(id: Int, firstName: String, lastName: String) : this(id , "$firstName $lastName") {
    }
}

// 5. FELADAT
// Készíts egy Member osztályt, id : Int, name : String, yearOfBirth : Int paraméterekkel

fun main() {
    // Nem kell new keyword
    val customerOld = CustomerOld()
    customerOld.id = 3
    customerOld.name = "Balázs"

    val customer = Customer(3, "Balázs")
    println(customer.name)
}