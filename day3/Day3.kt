package day3

/*
 *  Day3.kt
 *  AoC2021Kotlin
 *
 *  Created by Louis Edwards on 2022-01-25
 */

import java.io.File
import java.lang.StrictMath.pow


fun toBinary(value: ArrayList<Int>): String {

    val binaryString= buildString {
        for(i in 0 until 12)
            this.append(value[i])
    }
    return binaryString
}

fun binaryToInt(value: String): Int{
    var denaryNumber= 0
    var i= 1
    var j= 11
    while(i<=2048){
        when(value[j--]){
            '1' -> denaryNumber+= i
        }
        i*=2
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

        var binaryPair = Pair(0, 0) /*occurences of 1, occurences of 0*/

        for (j in 0 until binaryArray.size) { /* for every binary number in the file*/
            when (binaryArray[j][i]) {
                '1' -> {
                    binaryPair = binaryPair.copy(first = binaryPair.first + 1)
                }
                '0' -> binaryPair = binaryPair.copy(second = binaryPair.second + 1)
            }

        }
        println("totals for position ${pow(2.00, (11-i).toDouble()).toInt()}: ${binaryPair.first}, ${binaryPair.second}")
        if (binaryPair.first > binaryPair.second) {
            gamma.add(1)
            epsilon.add(0)
        }
        else {
            epsilon.add(1)
            gamma.add(0)
        }
    }

    val gammaString: String = toBinary(gamma)
    val epsilonString= toBinary(epsilon)
    val solutionValue= binaryToInt(gammaString) * binaryToInt(epsilonString)

    println("DAY3 | Gamma: $gammaString, ${binaryToInt(gammaString)}")
    println("DAY3 | Epsilon: $epsilonString, ${binaryToInt(epsilonString)}")
    println("DAY3 | totalling: $solutionValue")

}