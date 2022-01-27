package day3

/*
 *  File:    Day3
 *  Project: AoC2021Kotlin
 *
 *  Created by:       ledwa
 *  Started on:       2022-01-25
 *  Most Recent Edit: 2022-01-27
 */

import java.io.File
import java.lang.Math.pow


fun toBinary(value: ArrayList<Int>): String {

    val binaryString = buildString {
        for (i in 0 until 12)
            this.append(value[i])
    }
    return binaryString
}

fun binaryToInt(value: String): Int {
    var denaryNumber = 0
    var i = 1
    var j = 11
    while (i <= 2048) {
        when (value[j--]) {
            '1' -> denaryNumber += i
        }
        i *= 2
    }
    return denaryNumber
}

fun main() {
    val fileHandle = File("day3/binary.txt")

    val gamma = ArrayList<Int>()
    val epsilon = ArrayList<Int>()

    val binaryArray = ArrayList<String>()


    fileHandle.forEachLine {
        binaryArray.add(it)
    }

    for (i in 0 until 12) { /* for each position of the 12-bit binary number*/

        var binaryPair = Pair(0, 0) /*occurrences of 1, occurrences of 0*/

        for (j in 0 until binaryArray.size) { /* for every binary number in the file*/
            when (binaryArray[j][i]) {
                '1' -> binaryPair = binaryPair.copy(first = binaryPair.first + 1)
                '0' -> binaryPair = binaryPair.copy(second = binaryPair.second + 1)
            }

        }
        val position: Int = pow(2.00, (11 - i).toDouble()).toInt()
        println("totals for position $position: ${binaryPair.first}, ${binaryPair.second}")

        if (binaryPair.first > binaryPair.second) {
            gamma.add(1)
            epsilon.add(0)
        } else {
            epsilon.add(1)
            gamma.add(0)
        }
    }

    val gammaString: String = toBinary(gamma)
    val epsilonString: String = toBinary(epsilon)
    val solutionValue: Int = binaryToInt(gammaString) * binaryToInt(epsilonString)

    println("DAY3 | Gamma: $gammaString, ${binaryToInt(gammaString)}")
    println("DAY3 | Epsilon: $epsilonString, ${binaryToInt(epsilonString)}")
    println("DAY3 | Totalling: $solutionValue")

}