package algorithms.medium

// https://leetcode.com/problems/search-in-rotated-sorted-array
class SearchInRotatedSortedArraySolution {

    fun search(nums: IntArray, target: Int): Int {
        return searchTargetByIndex(nums, target, 0, nums.lastIndex)
    }

    private fun searchTargetByIndex(nums: IntArray, target: Int, startIndex: Int, endIndex: Int): Int {
        val middle = ((endIndex - startIndex) / 2) + startIndex
        return if (nums[middle] == target) {
            middle
        } else {
            if (startIndex == endIndex || endIndex < 0 || startIndex > nums.size - 1) {
                -1
            } else if (nums[middle] >= nums[startIndex]) {
                if (target >= nums[startIndex] && target < nums[middle]) {
                    searchTargetByIndex(nums, target, startIndex, middle - 1)
                } else {
                    searchTargetByIndex(nums, target, middle + 1, endIndex)
                }
            } else {
                if (target <= nums[endIndex] && target > nums[middle]) {
                    searchTargetByIndex(nums, target, middle + 1, endIndex)
                } else {
                    searchTargetByIndex(nums, target, startIndex, middle - 1)
                }
            }
        }
    }
}
