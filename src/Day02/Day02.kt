package Day02

import readInput

fun main() {

    val testInput = readInput("Day02/Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

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
    var totalScore = 0
    input.forEach{ round ->
        val roundPicks = round.split(" ")
        val option = getOptionFromCode(roundPicks[0])
        val optionToPlay: Option
        if(roundPicks[1] == "X") { // Lose
            val weight = option.weight - 1
            optionToPlay = if(weight != 0) {
                getOptionByWeight(weight)
            } else {
                Option.SCISSORS
            }
        } else if(roundPicks[1] == "Y") { //Draw
            optionToPlay = getOptionByWeight(option.weight)
        } else { // Win
            val weight = option.weight + 1
            optionToPlay = if(weight > 3) {
                Option.ROCK
            } else {
                getOptionByWeight(weight)
            }
        }

        totalScore += playMatch(roundPicks[0], optionToPlay.code)
    }
    return totalScore
}
