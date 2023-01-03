package algorithms.easy

// https://leetcode.com/problems/array-partition
class ArrayPartitionSolution {

    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var maxSum = 0
        for (n in nums.indices step 2) {
            maxSum += nums[n]
        }
        return maxSum
    }
}