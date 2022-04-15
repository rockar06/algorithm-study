package algorithms.easy

// https://leetcode.com/problems/fibonacci-number/
class FibonacciNumberSolution {

    fun fib(n: Int): Int {
        val result = IntArray(n)
        result[0] = 0
        result[1] = 1
        for (index in 2..n) {
            result[index] = result[index - 1] + result[index - 2]
        }
        return result[n]
    }
}