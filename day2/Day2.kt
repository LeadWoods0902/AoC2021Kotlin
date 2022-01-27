package day2

/*
 *  Day2.kt
 *  AoC2021Kotlin
 *
 *  Created by Louis Edwards on 2022-01-25
 */

import java.io.File

fun main() {
    val fileHandle = File("day2/commands.txt")
    var horizontalDisplacement = 0
    var verticalDisplacement = 0

    fileHandle.forEachLine {
        when (it.split(' ')[0]) {
            "forward" -> horizontalDisplacement += it.split(' ')[1].toInt()
            "down" -> verticalDisplacement += it.split(' ')[1].toInt()
            "up" -> verticalDisplacement -= it.split(' ')[1].toInt()
        }
    }

    println("DAY2 | the sub went: $horizontalDisplacement horizontally and $verticalDisplacement vertically, totalling: ${verticalDisplacement * horizontalDisplacement}")
}

