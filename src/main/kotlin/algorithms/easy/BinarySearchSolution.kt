package algorithms.easy

// https://leetcode.com/problems/first-bad-version/
class BinarySearchSolution {
    fun search(nums: IntArray, target: Int): Int {
        return searchInArray(nums, target, 0, nums.size - 1)
    }

    private fun searchInArray(nums: IntArray, target: Int, startIndex: Int, endIndex: Int): Int {
        val middle = ((endIndex - startIndex) / 2) + startIndex
        return if (nums[middle] == target) {
            middle
        } else {
            if (startIndex == endIndex || endIndex < 0 || startIndex > nums.size - 1) {
                -1
            } else if (nums[middle] > target) {
                searchInArray(nums, target, startIndex, middle - 1)
            } else {
                searchInArray(nums, target, middle + 1, endIndex)
            }
        }
    }
}