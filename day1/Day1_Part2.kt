package day1

/* 
 *  File:    Day1_Part2
 *  Project: AoC2021Kotlin
 *
 *  Created by:       TheLeadenWoods (Louis Edwards)
 *  Started on:       31/01/2022
 *  Most Recent Edit: 31/01/2022
 *
 *  Purpose: 
 */
import java.io.File
import kotlin.collections.ArrayList

fun main() {
    val depthsArray = ArrayList<Int>()
    val fileHandle = File("day1/depths.txt")
    var increaseCount = 0

    /*add each line of the file into an array as an integer value*/
    fileHandle.forEachLine {
        depthsArray.add(it.toInt())
    }

    /*iterate through the n-1 elements after element 1, comparing to the previous element to determine difference*/
    for (i in 2 until depthsArray.size-1) {
        println("${depthsArray[i-2]} + ${depthsArray[i-1]} + ${depthsArray[i]} = ${depthsArray[i] + depthsArray[i-1] + depthsArray[i-2]}")
        println("${depthsArray[i-1]} + ${depthsArray[i]} + ${depthsArray[i+1]} = ${depthsArray[i] + depthsArray[i-1] + depthsArray[i+1]}")

        if ((depthsArray[i]+depthsArray[i-1]+depthsArray[i-2]) < (depthsArray[i-1]+depthsArray[i]+depthsArray[i+1])){
            println("${depthsArray[i] + depthsArray[i-1] + depthsArray[i+1]} > ${depthsArray[i] + depthsArray[i-1] + depthsArray[i-2]}")
            increaseCount += 1
        }
        else{
            println("${depthsArray[i] + depthsArray[i-1] + depthsArray[i+1]} <= ${depthsArray[i] + depthsArray[i-1] + depthsArray[i-2]}")
        }
        println()
    }

    println("DAY1 | [${depthsArray[0]}..${depthsArray[depthsArray.size - 1]}] (${depthsArray.size} terms) has $increaseCount positive depth changes based on a 3-part sliding window.\n")
}