package com.paul.activitys.kotlin

fun main () {
    var name : String? = null
    println(name?.get(2) ?: "es un valor nulo")
}