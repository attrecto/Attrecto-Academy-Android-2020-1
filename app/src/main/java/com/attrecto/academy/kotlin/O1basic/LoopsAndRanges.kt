package com.attrecto.academy.kotlin.O1basic

fun main(args: Array<String>) {

    // Egyszerű for ciklus (a fordító megintcsak kitalálja a típusát)
    for (i in 1..10) {
        println(i)
    }

    // A fenti intervallumot (range) külön is létrehozhatjuk
    val numbers = 1..10

    // és bejárhatjuk őt is
    for (i in numbers) {
        println(i)
    }

    // a range nem működik visszafelé (üres intervallum), de van helyette downTo
    for (i in 10..1) {
        println(i)
    }

    // Kicsit összetettebb for
    for (i in 100 downTo 1 step 5) {
        println(i)
    }

    // Nem csak számokra van for
    val capitals = listOf("London", "Paris", "Madrid")
    for (capital in capitals) {
        println(capital)
    }

    // 2. FELADAT
    // Írd ki a 7-tel osztható számokat 1 től 100-ig
    for (i in 7..100 step 7) {
        println(i)
    }
}