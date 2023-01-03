package algorithms.medium

// https://leetcode.com/problems/minimum-size-subarray-sum
class MinimumSizeSubarraySumSolution {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var leftPointer = 0
        var rightPointer = 0
        var totalSum = 0
        var lengthResult = 0

        while (leftPointer < nums.size) {
            if (totalSum >= target) {
                lengthResult = if (lengthResult == 0) {
                    rightPointer - leftPointer
                } else {
                    Math.min(lengthResult, rightPointer - leftPointer)
                }
                totalSum -= nums[leftPointer++]
            } else {
                if (rightPointer <= nums.lastIndex) {
                    totalSum += nums[rightPointer++]
                } else {
                    leftPointer++
                }
            }
        }

        return lengthResult
    }
}