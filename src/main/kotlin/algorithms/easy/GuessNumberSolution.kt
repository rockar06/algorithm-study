package algorithms.easy

// https://leetcode.com/problems/guess-number-higher-or-lower/
class GuessNumberSolution {

    fun guessNumber(n: Int): Int {
        return findGuessNumber(1, n)
    }

    fun findGuessNumber(min: Int, max: Int): Int {
        if (guess(max) == 0) return max
        val middle = ((max - min) / 2) + min
        return when (guess(middle)) {
            0 -> return middle
            -1 -> findGuessNumber(min, middle)
            1 -> findGuessNumber(middle, max)
            else -> throw NoSuchElementException()
        }
    }

    fun guess(num: Int): Int {
        val value = Int.MAX_VALUE
        return if (num < value) {
            1
        } else if (num > value) {
            -1
        } else {
            0
        }
    }
}