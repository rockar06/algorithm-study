package algorithms.easy

// https://leetcode.com/problems/squares-of-a-sorted-array/
class SquaresOfASortedArraySolution {
    fun sortedSquares(nums: IntArray): IntArray {
        nums.forEachIndexed { index, item ->
            nums[index] = item * item
        }
        applyInsertionSort(nums)
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

    private fun applySelectionSort(nums: IntArray) {
        var sorted = false
        var minIndex = 0
        var tempValue: Int
        var lowestValueIndex = -1
        while (sorted.not()) {
            sorted = true
            for (index in minIndex until nums.size) {
                if (index == minIndex || nums[index] < nums[lowestValueIndex]) {
                    lowestValueIndex = index
                    sorted = false
                }
            }
            if (sorted.not() && nums[minIndex] != nums[lowestValueIndex]) {
                tempValue = nums[minIndex]
                nums[minIndex] = nums[lowestValueIndex]
                nums[lowestValueIndex] = tempValue
            }
            minIndex++
        }
    }

    private fun applyInsertionSort(nums: IntArray) {
        var tempValue: Int
        var position: Int
        for (index in 1 until nums.size) {
            tempValue = nums[index]
            position = index - 1
            while (position >= 0 && nums[position] > tempValue) {
                nums[position + 1] = nums[position]
                position -= 1
            }
            nums[position + 1] = tempValue
        }
    }
}