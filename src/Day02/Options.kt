package Day02

import java.lang.RuntimeException

enum class Option(val weight: Int, val code: String, val secondCode: String) {

    ROCK(1, "A", "X"),
    PAPER(2, "B", "Y"),
    SCISSORS(3, "C", "Z");

}

fun getOptionFromCode(code: String): Option {
    if(Option.ROCK.code == code || Option.ROCK.secondCode == code) {
        return Option.ROCK
    } else if(Option.PAPER.code == code || Option.PAPER.secondCode == code) {
        return Option.PAPER
    } else if(Option.SCISSORS.code == code || Option.SCISSORS.secondCode == code) {
        return Option.SCISSORS
    }
    throw RuntimeException("Unrecognised option code provided.")
}