package algorithms.medium

// https://leetcode.com/problems/find-peak-element
class FindPeakElementSolution {

    fun findPeakElement(nums: IntArray): Int {
        var leftIndex = 0
        var rightIndex = nums.lastIndex

        while (leftIndex <= rightIndex) {
            if (validateNumber(nums, leftIndex)) {
                return leftIndex
            }
            if (validateNumber(nums, rightIndex)) {
                return rightIndex
            }
            leftIndex++
            rightIndex--
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