package algorithms.medium

// https://leetcode.com/problems/find-peak-element
class FindPeakElementSolution {

    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        for (index in nums.indices step 2) {
            if (validateNumber(nums, index)) {
                return index
            }
        }

        for (index in 1 until nums.size step 2) {
            if (validateNumber(nums, index)) {
                return index
            }
        }
        return 0
    }

    private fun validateNumber(nums: IntArray, index: Int): Boolean {
        return if ((index - 1) >= 0 && (index + 1) <= nums.size - 1) {
            nums[index] > nums[index - 1] && nums[index] > nums[index + 1]
        } else if ((index - 1) >= 0 && (index + 1) >= nums.size) {
            nums[index] > nums[index - 1]
        } else {
            nums[index] > nums[index + 1]
        }
    }
}