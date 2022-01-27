package day4

/*
 *  File:    Day4
 *  Project: AoC2021Kotlin
 *
 *  Created by:       ledwa
 *  Started on:       2022-01-27
 *  Most Recent Edit: 2022-01-27
 *
 *  Purpose: calculate which of set of bingo boards will be completed first given a string of numbers to be called
 */

import java.io.File
import kotlin.system.exitProcess


class BingoBoard {
    var boardValues = ArrayList<Int>()


    /*used in testing*/
    override fun toString(): String {
        val outString = buildString {
            for (i in 0 until 5) {
                this.append("\n|")
                for (j in 0 until 5) {
                    this.append("${boardValues[j + (5 * i)]} ")
                }
                this.append("|")
            }
        }

        return outString
    }
}


fun main() {
    val fileHandleBingoBoards = File("day4/Boards.txt")
    val fileHandleBingoNumbers = File("day4/bingoNumbers.txt")

    val bingoBoardArrayList = ArrayList<BingoBoard>()

    var i = 0
    var j = -1

    fileHandleBingoBoards.forEachLine {
        if (it.isNotBlank()) {
            if (i.mod(5) == 0) {
                bingoBoardArrayList.add(BingoBoard())
                j++
            }

            val valuesOnRow = it.split(' ')

            for (k in valuesOnRow.indices) {
                if (valuesOnRow[k] != "") {
                    bingoBoardArrayList[j].boardValues.add(valuesOnRow[k].toInt())
                }
            }
            i++
        }
    }

    fileHandleBingoNumbers.forEachLine {
        for (k in 0 until bingoBoardArrayList.size) {
            val board: BingoBoard = bingoBoardArrayList[k]
            for (index in 0 until board.boardValues.size) {
                if (board.boardValues[index] == it.toInt())
                    board.boardValues[index] = -1
            }
            if (checkStates(board.boardValues)) {
                println("BINGO on board: \n$board")
                println(getBoardSum(board.boardValues) * it.toInt())
                exitProcess(-1)
            }
        }
    }
}

fun getBoardSum(board: ArrayList<Int>): Int{
    var returnSum =  0
    for(value in board){
        if(value != -1){
            returnSum+= value
        }
    }
    return returnSum
}


fun checkStates(board: ArrayList<Int>): Boolean {
    val scoredPositions = ArrayList<Int>()
    var horizontalStreak = 0


    for (index in 0 until board.size) {
        if(index.mod(5)== 0){
            if(horizontalStreak== 1) {
                println("Horizontal Bingo Found")
                return true
            }
            else
                horizontalStreak= 1
        }
        if (board[index] == -1)
            scoredPositions.add(index)
        else
            horizontalStreak = 0

        if(index >= 20){
            if(checkColumn(board, index)){
                println("Vertical Bingo Found")
                return true
            }
        }
    }
    if(checkDiagonals(board)) {
        println("Diagonal Bingo Found")
        return true
    }
    return false
}

fun checkColumn(states: ArrayList<Int>, index: Int): Boolean{
    return (states[index]==    -1 &&
            states[index-5]==  -1 &&
            states[index-10]== -1 &&
            states[index-15]== -1 &&
            states[index-20]== -1   )

}

fun checkDiagonals(states: ArrayList<Int>): Boolean{
    return (states[24]== -1 &&
            states[18]== -1 &&
            states[12]== -1 &&
            states[6]==  -1 &&
            states[0]==  -1 ||
            states[20]== -1 &&
            states[16]== -1 &&
            states[12]== -1 &&
            states[8]==  -1 &&
            states[4]==  -1 )
}