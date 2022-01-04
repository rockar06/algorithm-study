package algorithms.medium

// https://leetcode.com/problems/powx-n/submissions/
class PowSolution {

    private val positiveOne = 1.toDouble()
    private val negativeOne = (-1).toDouble()

    fun myPow(x: Double, n: Int): Double {
        if (n == 0 || x == positiveOne) return positiveOne
        if (x == negativeOne && (n != 1 && n % 2 == 0)) {
            return positiveOne
        } else if (x == negativeOne && n % 2 != 0) {
            return negativeOne
        }
        var result: Double = x
        var powCounter: Int
        if (n < 0) {
            powCounter = -1
            result = 1 / result
            while (powCounter > n) {
                if (powCounter < -1 && (result == 0.toDouble() || result == 1.toDouble())) return 0.toDouble()
                val tempResult = result
                result *= 1 / x
                if (result < -100000 || result > 100000) return tempResult
                powCounter--
            }
        } else {
            powCounter = 1
            while (powCounter < n) {
                if (powCounter > 1 && result == 0.toDouble()) return 0.toDouble()
                val tempResult = result
                result *= x
                if (result < -100000 || result > 100000) return tempResult
                powCounter++
            }
        }
        return result
    }
}