package Day03

import readInput

private val ALPHABET_INDEX = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun main() {

    val testInput = readInput("Day03/Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

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
    //Find groups of 3 lines
    val currentGroup = mutableListOf<String>()
    var total = 0
    input.forEach{
        currentGroup.add(it)
        if(currentGroup.size == 3) {
            val firstElf = currentGroup[0]
            val secondElf = currentGroup[1].split("").drop(1).dropLast(1).toMutableList()

            // Find all common items between Elf one and two
            val elfOneAndTwoCommonItems = mutableListOf<String>()

            var currentMatchingItem = firstElf.findAnyOf(secondElf, 0, false)?.second
            while(!currentMatchingItem.isNullOrBlank()) {
                elfOneAndTwoCommonItems.add(currentMatchingItem)
                while(secondElf.contains(currentMatchingItem)) { // Remove any duplicate matching items from secondElf to not match them again.
                    secondElf.remove(currentMatchingItem)
                }
                currentMatchingItem = firstElf.findAnyOf(secondElf, 0, false)?.second
            }

            // Find the one matching item between elf three and array of all matches between one and two.
            val idCardValue = currentGroup[2].findAnyOf(elfOneAndTwoCommonItems, 0, false)!!.second

            // Calculate priority value from index
            val priority = ALPHABET_INDEX.indexOf(idCardValue) + 1

            // Add to total
            total += priority

            // Clear current working group so can focus on the next three elves.
            currentGroup.clear()
        }
    }

    return total
}