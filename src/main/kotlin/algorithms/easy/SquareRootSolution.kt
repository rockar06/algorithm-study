package algorithms.easy

// https://leetcode.com/problems/sqrtx/
class SquareRootSolution {
    fun mySqrt(x: Int): Int {
        if (x == 0 || x == 1) return x
        var iteration = 1
        var result = 1
        while (result in 1..x) {
            iteration++
            result = iteration * iteration
        }
        return --iteration
    }
}