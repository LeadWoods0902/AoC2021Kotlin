package day3

/*
 *  File:    Day3
 *  Project: AoC2021Kotlin
 *
 *  Created by:       TheLeadenWoods (Louis Edwards)
 *  Started on:       2022-01-25
 *  Most Recent Edit: 2022-01-28
 *
 *  Purpose:  read through a file, converting
 *  binary numbers into Gamma & epsilon values,
 *  using the greatest occurrence to determine
 *  bit value by index
 */

import java.io.File
import kotlin.math.pow
import kotlin.system.exitProcess


/*convert an array of ints into binary*/
fun toBinary(value: ArrayList<Int>): String {

    val binaryString = buildString {
        for (i in 0 until 12) {
            if ((0..1).contains(value[i]))
                this.append(value[i])
            else {
                return "-1"
            }
        }
    }
    return binaryString
}

fun binaryToInt(value: String): Int {
    var denaryNumber = 0
    var i = 1
    var j = 11
    while (i <= 2048) {
        when (value[j--]) {
            '1'  -> {denaryNumber += i; i*=2}
            '0'  -> i*=2
            else -> return -4096

        }
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
            binaryPair = when (binaryArray[j][i]) {
                '1' -> binaryPair.copy(first = binaryPair.first + 1)
                '0' -> binaryPair.copy(second = binaryPair.second + 1)
                else -> {
                    binaryPair.copy()
                    exitProcess(-1)
                }
            }
        }
        val position: Int = 2.00.pow((11 - i).toDouble()).toInt()
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

    if(gammaString == "-1" || epsilonString== "-1"){
        println("ERROR| Invalid binary passed to binary converter")
        exitProcess(-1)
    }

    val solutionValue: Int = binaryToInt(gammaString) * binaryToInt(epsilonString)

    println("DAY3 | Gamma: $gammaString, ${binaryToInt(gammaString)}")
    println("DAY3 | Epsilon: $epsilonString, ${binaryToInt(epsilonString)}")
    println("DAY3 | Totalling: $solutionValue")

}