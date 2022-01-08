package algorithms.easy

// https://leetcode.com/problems/search-insert-position/submissions/
class SearchInsertPositionSolution {
    /*fun searchInsert(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { index, value ->
            if (target <= value) return index
        }
        return nums.size
    }*/

    fun searchInsert(nums: IntArray, target: Int): Int {
        return findInsertPosition(nums, target, 0, nums.size - 1)
    }

    private fun findInsertPosition(nums: IntArray, target: Int, min: Int, max: Int): Int {
        val middle = ((max - min) / 2) + min
        return when {
            target < nums[min] && min == middle -> min
            target > nums[max] && max == middle -> max + 1
            target > nums[middle] -> findInsertPosition(nums, target, middle + 1, max)
            target == nums[middle] -> middle
            target < nums[middle] -> findInsertPosition(nums, target, min, middle - 1)
            else -> throw IllegalArgumentException()
        }
    }
}