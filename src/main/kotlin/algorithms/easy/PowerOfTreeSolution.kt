package algorithms.easy

import kotlin.math.log
import kotlin.math.pow

class PowerOfTreeSolution {
    fun isPowerOfThree(n: Int): Boolean {
        if (n < 1) return false
        val result = log(n.toFloat(), 3.toFloat())
        return 3.0.pow(result.toDouble()) == n.toDouble()
    }
}