package algorithms.easy

// https://leetcode.com/problems/number-of-1-bits/
class NumberOfOneBitsSolution {
    fun hammingWeight(n: Int): Int {
        var counter = 0
        var number = n
        for (index in 0 until 32) {
            if (number or 1 == number) {
                counter++
            }
            number = number shr 1
        }
        return counter
    }
}