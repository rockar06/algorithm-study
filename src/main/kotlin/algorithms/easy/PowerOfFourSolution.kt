package algorithms.easy

import kotlin.math.log

// https://leetcode.com/problems/counting-bits/
class PowerOfFourSolution {
    fun isPowerOfFour(n: Int): Boolean {
        if (n < 1) return false
        val result = log(n.toFloat(), 4.0f)
        return result % 1.0 == 0.0
    }
}