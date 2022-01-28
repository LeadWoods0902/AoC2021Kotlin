package day5

/* 
 *  File:    Day5
 *  Project: AoC2021Kotlin
 *
 *  Created by:       TheLeadenWoods (Louis Edwards)
 *  Started on:       2022-01-28
 *  Most Recent Edit: 2022-01-28
 *
 *  Purpose:
 */

import java.io.File

fun main(){
    val fileHandler= File("day5/vents.txt")
    val ventsArray2D= ArrayList<ArrayList<Int>>(1000)

    fileHandler.forEachLine {
        val startPair: Pair<Int, Int> = Pair(it.split(" -> ")[0].split(',')[0].toInt(), it.split(" -> ")[0].split(',')[1].toInt())
        val endPair: Pair<Int, Int>  = Pair(it.split(" -> ")[1].split(',')[0].toInt(), it.split(" -> ")[1].split(',')[1].toInt())

        for(x in startPair.first..endPair.first){
            for(y in startPair.first..endPair.second){
                ventsArray2D[x][y]+=1
            }
        }
    }
}