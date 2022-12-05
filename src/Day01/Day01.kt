package Day01

import readInput

fun main() {
    fun getElfBagTotals(input: List<String>): MutableList<Int> {
        val bagTotals = mutableListOf<Int>()
        var currentTotal = 0
        input.forEach { line ->
            if (line == "") {
                bagTotals.add(currentTotal)
                currentTotal = 0
            } else {
                currentTotal += line.toInt()
            }
        }
        return bagTotals
    }

    fun part1(input: List<String>): Int {
        val bagTotals = getElfBagTotals(input)
        return bagTotals.max()
    }

    fun part2(input: List<String>): Int {
        val bagTotals = getElfBagTotals(input)
        bagTotals.sortDescending()
        return bagTotals.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01/Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01/Day01")
    println("Part 1: ".plus(part1(input)))
    println("Part 2: ".plus(part2(input)))
}
