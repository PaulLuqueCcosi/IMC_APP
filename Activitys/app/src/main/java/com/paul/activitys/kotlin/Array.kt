package com.paul.activitys.kotlin

fun main() {
    var name:String = "Lunes"
    var name2:String = "Martes"
    var name3:String = "Miercoles"
    var name4:String = "Jueves"
    var name5: String = "Viernes"

    var week = arrayListOf(name, name2, name3, name4, name5)
    println(week)


    for (day in week ){
        println(day)
    }

    for ((pos, value) in week.withIndex()){
        println("Posi ${pos} : ${value}")
    }
}