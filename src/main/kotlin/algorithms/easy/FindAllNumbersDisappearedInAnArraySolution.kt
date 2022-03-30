package algorithms.easy

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
class FindAllNumbersDisappearedInAnArraySolution {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        val mapHelper = hashMapOf<Int, Boolean>()
        nums.forEach {
            mapHelper[it] = true
        }

        nums.forEach {

        }

        for (index in nums.indices) {
            if (mapHelper.getOrDefault(index + 1, false).not()) {
                result.add(index + 1)
            }
        }
        return result
    }
}