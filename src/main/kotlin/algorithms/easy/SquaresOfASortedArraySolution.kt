package algorithms.easy

// https://leetcode.com/problems/squares-of-a-sorted-array/
class SquaresOfASortedArraySolution {
    fun sortedSquares(nums: IntArray): IntArray {
        nums.forEachIndexed { index, item ->
            nums[index] = item * item
        }
        applyBubbleSort(nums)
        return nums
    }

    private fun applyBubbleSort(nums: IntArray) {
        var sorted = false
        var maxIndex = nums.size - 1
        var tempValue: Int
        while (sorted.not()) {
            sorted = true
            for (index in 0 until maxIndex) {
                if (nums[index] > nums[index + 1]) {
                    tempValue = nums[index]
                    nums[index] = nums[index + 1]
                    nums[index + 1] = tempValue
                    sorted = false
                }
            }
            maxIndex--
        }
    }
}