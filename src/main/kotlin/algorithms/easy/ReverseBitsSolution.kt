package algorithms.easy

// https://leetcode.com/problems/reverse-bits
class ReverseBitsSolution {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var currentNumber = n
        var result = 0
        for (index in 0 until 32) {
            result = result shl 1
            if (currentNumber or 1 == currentNumber) {
                result = result or 1
            }
            currentNumber = currentNumber shr 1
        }
        return result
    }
}