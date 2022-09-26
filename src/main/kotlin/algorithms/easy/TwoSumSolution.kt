package algorithms.easy

// https://leetcode.com/problems/two-sum/
class TwoSumSolution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val verifyNumberMap = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, number ->
            verifyNumberMap[target - number]?.let {
                return intArrayOf(it, index)
            } ?: run {
                verifyNumberMap[number] = index
            }
        }
        return intArrayOf()
    }
}