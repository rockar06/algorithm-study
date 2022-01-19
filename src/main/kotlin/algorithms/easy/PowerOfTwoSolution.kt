package algorithms.easy

import kotlin.math.log2
import kotlin.math.pow

// https://leetcode.com/problems/power-of-two/
class PowerOfTwoSolution {

    fun isPowerOfTwo(n: Int): Boolean {
        if (n < 1) return false
        val result = log2(n.toFloat())
        return 2.0.pow(result.toDouble()) == n.toDouble()
    }

    /*
    Bit Manipulation solution
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 0 || n == Int.MIN_VALUE) return false
        return n and -n == n
    }
     */
}
