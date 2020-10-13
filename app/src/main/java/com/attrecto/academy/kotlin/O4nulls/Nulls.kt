package com.attrecto.academy.kotlin.O4nulls

class Service{
    fun evaluate(){}
}

class ServiceProvider(){
    fun createService() : Service?{
        return null
    }
}

fun main() {
    // Amikor deklarálod a változót, NEM lehet null.
    val message: String = ""
    println(message)

    // Ez remek, de néha azért szükség van null-okra!
    var nullMessage: String? = null

    // Lehet null check, mint eddig java-ban
    if(nullMessage != null){
        println(nullMessage.length)
    }

    println(nullMessage?.length)

    // A fordító nagyon okos, ha biztosan nem null, akkor lehet ? nélkül
    nullMessage = "hello"
    println(nullMessage.length)

    val provider = createServiceProvider()
    provider?.createService()?.evaluate()
}

private fun createServiceProvider() : ServiceProvider?{
    return null
}