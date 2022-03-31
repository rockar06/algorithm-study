package algorithms.easy

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
class FindAllDuplicatesInAnArraySolution {

    fun findDuplicates(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        nums.sort()
        var index = 0
        while (index < nums.size - 1) {
            if (nums[index] == nums.getOrNull(index + 1)) {
                result.add(nums[index])
                index += 2
            } else {
                index++
            }
        }
        return result
    }
}