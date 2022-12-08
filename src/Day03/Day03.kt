package Day03

import readInput

private val ALPHABET_INDEX = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun main() {

    val testInput = readInput("Day03/Day03_test")
    check(part1(testInput) == 157)
//    check(part2(testInput) == 12)

    val input = readInput("Day03/Day03")

    println("Part 1: ".plus(part1(input)))
    println("Part 2: ".plus(part2(input)))
}

fun part1(input: List<String>): Int {
    var total = 0
    input.forEach{
        // Split the line in half
        val halfWayPoint = it.length / 2
        val firstHalf = it.take(halfWayPoint)
        val secondHalf = it.takeLast(halfWayPoint).split("").drop(1).dropLast(1)

        // Compare two halves and find common value
        val matchingCharacter = firstHalf.findAnyOf(secondHalf, 0, false)!!.second

        // Compare common value to priority table.
        val priority = ALPHABET_INDEX.indexOf(matchingCharacter) + 1

        // Add up all priority values.
        total += priority
    }

    return total
}

fun part2(input: List<String>): Int {
    return 0
}