package algorithms.medium

// https://leetcode.com/problems/range-sum-query-immutable/
class NumArray(private val nums: IntArray) {

    fun sumRange(left: Int, right: Int): Int {
        var result = 0
        var leftIndex = left
        var rightIndex = right
        while (leftIndex <= rightIndex) {
            result += if (leftIndex == rightIndex) {
                nums[leftIndex]
            } else {
                nums[leftIndex] + nums[rightIndex]
            }
            leftIndex++
            rightIndex--
        }
        return result
    }
}