package Day02

import readInput

fun main() {

    val testInput = readInput("Day02/Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02/Day02")

    println("Part 1: ".plus(part1(input)))
    println("Part 2: ".plus(part2(input)))
}

fun part1(input: List<String>): Int {
    var totalScore = 0
        input.forEach{ round ->
        val roundPicks = round.split(" ")
        totalScore += playMatch(roundPicks[0], roundPicks[1])
    }
    return totalScore
}

fun playMatch(opponentPick: String, myPick: String): Int {
    val opponentPickOption = getOptionFromCode(opponentPick)
    val myPickOption = getOptionFromCode(myPick)
    val outcomeScore = if((myPickOption == Option.ROCK && opponentPickOption == Option.SCISSORS) || (myPickOption.weight > opponentPickOption.weight && !(myPickOption == Option.SCISSORS && opponentPickOption == Option.ROCK))){
        6
    } else if(myPickOption.weight == opponentPickOption.weight) {
        3
    } else {
        0
    }

    val totalScore = outcomeScore + myPickOption.weight
    return totalScore
}


fun part2(input: List<String>): Int {
    return 0
}
