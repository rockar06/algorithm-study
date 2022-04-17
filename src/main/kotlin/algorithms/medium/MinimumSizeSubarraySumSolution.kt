package algorithms.medium

// https://leetcode.com/problems/minimum-size-subarray-sum
class MinimumSizeSubarraySumSolution {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var leftPointer = 0
        var rightPointer = -1
        var currentSum = 0
        var minimumSize = 0
        while (leftPointer < nums.size) {
            if (currentSum >= target) {
                minimumSize = if (minimumSize == 0) {
                    (rightPointer + 1) - leftPointer
                } else {
                    Math.min((rightPointer + 1) - leftPointer, minimumSize)
                }
                currentSum -= nums[leftPointer++]
            } else {
                if (rightPointer < nums.size - 1) {
                    currentSum += nums[++rightPointer]
                } else {
                    leftPointer++
                }
            }
        }
        return minimumSize
    }
}