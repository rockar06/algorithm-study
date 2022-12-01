package algorithms.easy

// https://leetcode.com/problems/find-pivot-index
class FindPivotIndexSolution {

    fun pivotIndex(nums: IntArray): Int {
        var leftItemsSum = 0
        var rightItemsArray = nums.sum()

        nums.forEachIndexed { index, item ->
            if (rightItemsArray - item == leftItemsSum) {
                return index
            }
            leftItemsSum += item
            rightItemsArray -= item
        }

        return -1
    }
}