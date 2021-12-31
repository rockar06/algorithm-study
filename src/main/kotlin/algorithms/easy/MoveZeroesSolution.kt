package algorithms.easy

// https://leetcode.com/problems/move-zeroes/submissions/
class MoveZeroesSolution {
    fun moveZeroes(nums: IntArray) {
        if (nums.size == 1) return
        var nonZeroIndex = 0
        for (index in nums.indices) {
            if (nums[index] != 0) {
                nums[nonZeroIndex] = nums[index]
                nonZeroIndex++
            }
        }
        for (index in nonZeroIndex until nums.size) {
            nums[index] = 0
        }
    }
}
