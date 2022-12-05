package Day02

import readInput

val lose = 0
val draw = 3
val won = 6

val rock = 1 // A | X
val paper = 2 // B | Y
val scissors = 3 // C | Z



fun main() {

    val testInput = readInput("Day02/Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02/Day02")

    println("Part 1: ".plus(part1(input)))
    println("Part 2: ".plus(part2(input)))
}

fun part1(input: List<String>): Int {
    val line = "A Y"
    val roundPicks = line.split(" ")

    return playMatch(roundPicks[0], roundPicks[1])
}

fun playMatch(myPick: String, opponentPick: String): Int {
    //Convert A/Y to Rock / Paper etc
    val myPickOption = getOptionFromCode(myPick)
    val opponentPickOption = getOptionFromCode(opponentPick)


    // Find the winner

    // Return score + choice


    return 0
}


fun part2(input: List<String>): Int {
    return 0
}
