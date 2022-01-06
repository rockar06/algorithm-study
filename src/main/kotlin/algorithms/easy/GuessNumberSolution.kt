package algorithms.easy

// https://leetcode.com/problems/guess-number-higher-or-lower/
// TODO: Finish solution for Guess Number exercise
class GuessNumberSolution {
    fun guessNumber(n: Int): Int {
        var guessNumber = n / 2
        while (guessNumber in 1 until n) {
            when (guess(guessNumber)) {
                -1 -> {
                    guessNumber -= ((n - guessNumber) / 2)
                }
                //1 -> { guessNumber = (n + guessNumber) / 2 }
                1 -> {
                    guessNumber += ((n - guessNumber) / 2)
                }
                0 -> return guessNumber
            }
        }
        return 0
    }

    fun guess(num: Int): Int {
        val value = 4
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
    val result = GuessNumberSolution().guessNumber(10)
    result
}