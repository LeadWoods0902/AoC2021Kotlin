package day1

/*
 *  File:    Day1_Part1
 *  Project: AoC2021Kotlin
 *
 *  Created by:       TheLeadenWoods (Louis Edwards)
 *  Started on:       2022-01-25
 *  Most Recent Edit: 2022-01-28
 *
 *  Purpose: Read through a file, counting the
 *  number of increments between two adjacent
 *  values: arr[i] < arr[i+1].
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
    for (i in 1 until depthsArray.size) {
        if (depthsArray[i] > depthsArray[i - 1])
            increaseCount += 1
    }

    println("DAY1 | [${depthsArray[0]}..${depthsArray[depthsArray.size - 1]}] (${depthsArray.size} terms) has $increaseCount positive depth changes.\n")
}