package day1

/*
 *  Day1.kt
 *  AoC2021Kotlin
 *
 *  Created by Louis Edwards on 2022-01-25
 */


import java.io.File
import kotlin.collections.ArrayList

fun main() {
    val depthsArray= ArrayList<Int>()
    val fileHandle = File("day1/depths.txt")
    var readText: String

    var increaseCount = 0

        fileHandle.forEachLine {
            readText = it
            depthsArray.add(readText.toInt())
        }

    for(i in 1 until depthsArray.size){
        if(depthsArray[i] > depthsArray[i-1])
            increaseCount+= 1
    }

    println("DAY1 | [${depthsArray[0]}..${depthsArray[depthsArray.size-1]}] (${depthsArray.size} terms) has $increaseCount positive depth changes.\n")
}