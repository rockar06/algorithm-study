package algorithms.easy

// https://leetcode.com/problems/search-insert-position/submissions/
class SearchInsertPositionSolution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { index, value ->
            if (target <= value) return index
        }
        return nums.size
    }
}