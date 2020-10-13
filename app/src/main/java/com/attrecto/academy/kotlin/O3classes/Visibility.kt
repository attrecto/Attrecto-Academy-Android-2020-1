package com.attrecto.academy.kotlin.O3classes

// Class visibility

class Car {
    // A publikus visibility mindenhonnan látható, ez az alapértelmezett láthatóság, ki sem kell írni
    public val name: String = ""

    // private csak az osztályon belül látható
    private val id: String = ""

    // protected csak az osztályon belül, és a leszármazott osztályokban látható
    protected val type: String = ""

    // Csak abban a modulban látható amiben létrehozták
    internal val hp: Int = 100
}

// Top level visibility

// A publikus visibility mindenhonnan látható, ez az alapértelmezett láthatóság, ki sem kell írni
val publicCar = Car()

// Csak abban a fájlban látható, ahol létrehozták
private val privateCar = Car()

// Csak abban a modulban látható amiben létrehozták
internal val internalCar = Car()
