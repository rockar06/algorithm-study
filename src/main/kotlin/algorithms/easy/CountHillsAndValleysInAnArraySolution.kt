package algorithms.easy

import java.util.*

// https://leetcode.com/problems/count-hills-and-valleys-in-an-array
class CountHillsAndValleysInAnArraySolution {
    fun countHillValley(nums: IntArray): Int {
        var counter = 0
        val stackHelper = Stack<Int>()

        stackHelper.add(nums.first())

        nums.forEach {
            if (stackHelper.isNotEmpty() && stackHelper.peek() != it) {
                stackHelper.add(it)
            }
        }

        val nonRepeatedNumbers = stackHelper.toIntArray()
        var index = 1

        while (index < nonRepeatedNumbers.lastIndex) {
            if (nonRepeatedNumbers[index - 1] < nonRepeatedNumbers[index] && nonRepeatedNumbers[index] > nonRepeatedNumbers[index + 1]
                || nonRepeatedNumbers[index - 1] > nonRepeatedNumbers[index] && nonRepeatedNumbers[index] < nonRepeatedNumbers[index + 1]
            ) {
                counter++
            }
            index++
        }

        return counter
    }
}