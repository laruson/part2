package com.chernikovichandreygmail.lesson4

import android.graphics.Color
import android.graphics.Paint

fun sum(list: ArrayList<Int>): Int {
    var sum = 0
    for (item: Int in list)
        sum += item

    return sum
}

fun transfer(): ArrayList<Int> {
    val list = ArrayList<Int>()
    list.add(3)
    list.add(2)
    list.add(7)
    list.add(4)
    return list
}

fun paints(): ArrayList<Paint> {
    return arrayListOf(
            Paint().apply {
                color = Color.YELLOW
            },
            Paint().apply {
                color = Color.GREEN
            },
            Paint().apply {
                color = Color.BLUE
            },
            Paint().apply {
                color = Color.CYAN
            }
    )
}
