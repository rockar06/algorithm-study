package algorithms.easy

// https://leetcode.com/problems/missing-ranges/
class MissingRangesSolution {

    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if (nums.isEmpty()) {
            return result.apply {
                add(listOf(lower, upper))
            }
        }

        if (lower < nums.first()) {
            result.add(listOf(lower, nums.first() - 1))
        }

        for (index in 0 until nums.lastIndex) {
            if (nums[index + 1] - nums[index] > 1) {
                result.add(listOf(nums[index] + 1, nums[index + 1] - 1))
            }
        }


        if (upper > nums.last()) {
            result.add(listOf(nums.last() + 1, upper))
        }

        return result
    }
}