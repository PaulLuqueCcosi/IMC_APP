package com.paul.activitys.kotlin

fun main() {
    val readOnly:List<String> = listOf("Lunes", "Martes", "Miercoles", "Sabado")

    println(readOnly.map { it -> it.toString() + "agrega" })

    val mutableList : MutableList<String> = readOnly.toMutableList()

    mutableList.add("Otroooo")
    println(mutableList)
}