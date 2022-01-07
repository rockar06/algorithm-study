package algorithms.easy

import kotlin.math.abs
import kotlin.math.max

// https://leetcode.com/problems/guess-number-higher-or-lower/
// TODO: Finish solution for Guess Number exercise
class GuessNumberSolution {
    fun guessNumber(n: Int): Int {
/*        var guessNumber = n
        while (guessNumber != 11) {
            if (guess(guessNumber) == -1) {
                guessNumber -= guessNumber / 2
            } else if (guess(guessNumber) == 1) {
                guessNumber += guessNumber / 2
            }
        }
        return guessNumber*/
        var guessNumber = n
        var previousNumber = 0
        while (guess(guessNumber) != 0) {
            val temp = guessNumber
            if (guess(guessNumber) == -1) {
                guessNumber -= (abs(guessNumber - previousNumber) / 2)
                previousNumber = temp
            } else if (guess(guessNumber) == 1) {
                guessNumber += (abs(guessNumber - previousNumber) / 2)
                previousNumber = max(previousNumber, temp)
            }
        }
        return guessNumber
    }

    fun guess(num: Int): Int {
        //val value = Int.MAX_VALUE - 1
        val value = 1
        return if (num < value) {
            1
        } else if (num > value) {
            -1
        } else {
            0
        }
    }
}

fun main() {
    val result = GuessNumberSolution().guessNumber(Int.MAX_VALUE)
    result
}