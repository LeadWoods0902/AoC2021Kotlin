package day2

/*
 *  File:    Day2
 *  Project: AoC2021Kotlin
 *
 *  Created by:       ledwa
 *  Started on:       2022-01-25
 *  Most Recent Edit: 2022-01-27
 *
 *  Purpose: read through a file, "translating"
 *  commands into vertical and horizontal 
 *  displacement components.
 */

import java.io.File
import kotlin.math.abs

fun main() {
    val fileHandle = File("day2/commands.txt")
    /*var horizontalDisplacement = 0
    var verticalDisplacement = 0*/
    
    var displacementVH = Pair(0,0)

    fileHandle.forEachLine {
        when (it.split(' ')[0]) {
            /*"forward" -> horizontalDisplacement += it.split(' ')[1].toInt()
            "down" -> verticalDisplacement += it.split(' ')[1].toInt()
            "up" -> verticalDisplacement -= it.split(' ')[1].toInt()*/
            
            /*Vertical displacements*/
            "down" -> displacementVH = displacementVH.copy(first = displacementVH.first - 1)
            "up" -> displacementVH = displacementVH.copy(first = displacementVH.first + 1)

            /*Horizontal displacements*/
            "forward" -> displacementVH = displacementVH.copy(second = displacementVH.second + 1)

            /*while not in the data set, it allows for further expansion of the concept*/
            "backwards" -> displacementVH = displacementVH.copy(second = displacementVH.second - 1)
        }
    }

    displacementVH = displacementVH.copy(first = abs(displacementVH.first), second = abs(displacementVH.second))

    println("DAY2 | the sub displaced: ${displacementVH.first} horizontally and ${displacementVH.second} " +
            "vertically, totalling: ${displacementVH.first * displacementVH.second}")
}

