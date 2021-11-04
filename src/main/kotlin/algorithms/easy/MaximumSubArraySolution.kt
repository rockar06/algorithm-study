package algorithms.easy

// https://leetcode.com/problems/maximum-subarray/
class MaximumSubArraySolution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var currentSum = 0
        nums.forEach {
            if (currentSum < 0 && currentSum < it) {
                currentSum = it
            } else {
                currentSum += it
            }
            maxSum = if (maxSum >= currentSum) maxSum else currentSum
        }
        return maxSum
    }
}