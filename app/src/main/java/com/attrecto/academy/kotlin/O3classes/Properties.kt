package com.attrecto.academy.kotlin.O3classes

import java.lang.IllegalArgumentException
import java.util.*

class Member(val id: Int, var name: String, val yearOfBirth: Int) {

    val age: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth

    var socialSecurityNumber : String = ""
        set(value) {
            if(!value.startsWith("SN")){
                throw IllegalArgumentException()
            }
            field = value
        }

    // 6. FELADAT készíts egy "adult" property-t, ami megmondja hogy a member felnőtt-e vagy sem  (18 >=)

    val adult : Boolean
        get() = age >= 18

    // Nem csak property-jei, metódusai is lehetnek egy osztálynak
    fun customerAsString() : String {
        return  "$id - $name"
    }
}



fun main() {
    val member = Member(3, "Balázs", 2000)
    member.socialSecurityNumber = "SN123"
    println(member.age)
    println(member.socialSecurityNumber)
    println(member.adult)
    println(member.customerAsString())

}