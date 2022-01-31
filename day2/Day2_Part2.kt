package day2

import java.io.File
import kotlin.math.abs

/* 
 *  File:    Day2_Part2
 *  Project: AoC2021Kotlin
 *
 *  Created by:       TheLeadenWoods (Louis Edwards)
 *  Started on:       31/01/2022
 *  Most Recent Edit: 31/01/2022
 *
 *  Purpose: 
 */


fun main() {
    val fileHandle = File("day2/commands.txt")
    var displacementVH: Pair<Int, Int> = Pair(0,0)
    var aim = 0

    fileHandle.forEachLine {
        when (it.split(' ')[0]) {
            /*aim modification*/
            "down" -> aim+= it.split(' ')[1].toInt()
            "up" -> aim-= it.split(' ')[1].toInt()

            /*displacements modification*/
            "forward" -> {
                displacementVH = displacementVH.copy(first= displacementVH.first + (aim * it.split(' ')[1].toInt()), second = displacementVH.second + it.split(' ')[1].toInt())
                println("Aim: $aim, Horizontal Displacement: ${displacementVH.second}, Vertical Displacement: ${displacementVH.first}")
            }

        }
    }

    /*convert the displacements into positive values, as displacements, regardless of direction are positive*/
    displacementVH = displacementVH.copy(first = abs(displacementVH.first), second = abs(displacementVH.second))

    println("DAY2 | the sub displaced: ${displacementVH.first} horizontally and ${displacementVH.second} " +
            "vertically, totalling: ${displacementVH.first * displacementVH.second}")
}