package Day02

import readInput

val lose = 0
val draw = 3
val won = 6

val rock = 1 // A | X
val paper = 2 // B | Y
val scissors = 3 // C | Z


val results = mapOf("A X" to 4, "A Y" to 1, "A Z" to 7, "B X" to 8, "B Y" to 5, "B Z" to 2, "C X" to 3, "C Y" to 9, "C Z" to 6)

fun main() {

    val testInput = readInput("Day02/Day02_test")
//    check(part1(testInput) == 15)

    val input = readInput("Day02/Day02")

    println("Part 1: ".plus(part1(input)))
    println("Part 2: ".plus(part2(input)))
}

fun part1(input: List<String>): Int {
    var totalScore = 0
        input.forEach(){ round ->
        totalScore += playNewMatch(round)
//        val roundPicks = round.split(" ")
//        playMatch(roundPicks[0], roundPicks[1])
    }
    return totalScore
}

fun playNewMatch(round: String): Int {
    return results[round]!!
}

fun playMatch(myPick: String, opponentPick: String): Int {
    val myPickOption = getOptionFromCode(myPick)
    val opponentPickOption = getOptionFromCode(opponentPick)
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
