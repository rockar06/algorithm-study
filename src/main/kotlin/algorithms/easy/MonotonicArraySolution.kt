package algorithms.easy

// https://leetcode.com/problems/monotonic-array
class MonotonicArraySolution {

    fun isMonotonic(nums: IntArray): Boolean {
        return decreasingMonotonic(nums) || increasingMonotonic(nums)
    }

    private fun decreasingMonotonic(nums: IntArray): Boolean {
        nums.forEachIndexed { index, value ->
            if (nums.getOrNull(index + 1) != null && nums[index + 1] > value) {
                return false
            }
        }
        return true
    }

    private fun increasingMonotonic(nums: IntArray): Boolean {
        nums.forEachIndexed { index, value ->
            if (nums.getOrNull(index + 1) != null && nums[index + 1] < value) {
                return false
            }
        }
        return true
    }
}