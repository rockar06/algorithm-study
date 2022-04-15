package algorithms.easy

// https://leetcode.com/problems/maximum-average-subarray-i/
class MaximumAverageSubarrayISolution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var result: Double = 0.toDouble()
        var currentSum: Double = 0.toDouble()
        var leftPointer = 0
        var rightPointer = 0
        while (leftPointer <= nums.size - k) {
            currentSum += nums[rightPointer] // 1, 13, 8, 2
            if (((rightPointer + 1) - leftPointer) == k) {
                val averageResult: Double = currentSum / k
                result = if (result == 0.toDouble() && averageResult < 0) {
                    averageResult
                } else {
                    Math.max(averageResult, result)
                }
                currentSum -= nums[leftPointer++]

            }
            rightPointer++
        }
        return result
    }
}