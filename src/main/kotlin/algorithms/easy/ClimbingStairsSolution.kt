package algorithms.easy

// https://leetcode.com/problems/climbing-stairs/
class ClimbingStairsSolution {
    /*fun climbStairs(n: Int): Int {
        val arrayOfNumbers = IntArray(n + 1)
        arrayOfNumbers[0] = 1
        for (i in 1..n) {
            if (i == 1) {
                arrayOfNumbers[i] = arrayOfNumbers[i - 1]
            } else {
                arrayOfNumbers[i] = arrayOfNumbers[i - 1] + arrayOfNumbers[i - 2]
            }
        }
        return arrayOfNumbers.last()
    }*/

    fun climbStairs(n: Int): Int {
        if (n == 0 || n == 1) return 1
        val arrayOfNumbers = IntArray(n + 1)
        arrayOfNumbers[0] = 1
        arrayOfNumbers[1] = 1
        for (i in 2..n) {
            arrayOfNumbers[i] = arrayOfNumbers[i - 1] + arrayOfNumbers[i - 2]
        }
        return arrayOfNumbers.last()
    }
}