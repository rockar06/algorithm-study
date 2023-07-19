package algorithms.easy

// https://leetcode.com/problems/missing-number/
class MissingNumberSolution {

    fun missingNumber(nums: IntArray): Int {
        var result = 0
        for (index in nums.indices) {
            result += (index + 1)
        }

        nums.forEach {
            result -= it
        }

        return result
    }
}