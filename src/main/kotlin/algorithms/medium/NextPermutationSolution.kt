package algorithms.medium

// https://leetcode.com/problems/next-permutation
class NextPermutationSolution {

    fun nextPermutation(nums: IntArray) {
        var index = nums.size - 2
        while (index >= 0 && nums[index + 1] <= nums[index]) {
            index--
        }
        if (index >= 0) {
            var lastIndex = nums.lastIndex
            while (nums[lastIndex] <= nums[index]) {
                lastIndex--
            }
            nums.swap(index, lastIndex)
        }
        nums.reverse(index + 1)
    }

    private fun IntArray.swap(firstIndex: Int, secondIndex: Int) {
        val temp = this[firstIndex]
        this[firstIndex] = this[secondIndex]
        this[secondIndex] = temp
    }

    private fun IntArray.reverse(start: Int) {
        var startIndex = start
        var lastIndex = lastIndex
        while (startIndex < lastIndex) {
            swap(startIndex, lastIndex)
            startIndex++
            lastIndex--
        }
    }
}