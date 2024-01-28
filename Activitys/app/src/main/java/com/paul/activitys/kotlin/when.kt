package com.paul.activitys.kotlin

import androidx.compose.runtime.traceEventEnd

fun main() {
    getMonth(3)
    result(12)
    result("gola")
    result(true)
    result(12.3)
}


fun result(value : Any){
    when (value){
        is Int -> println("Value = ${value*value}")
        is String -> println(value)
        is Boolean -> if (value) println(value)
        else -> println("Typo no reconocido ${value.javaClass.simpleName}")
    }
}
fun getMonth(mont:Int) {
    when(mont){
        1 -> println("Enero")
        else -> println("otro mes no conocido")
    }
}
