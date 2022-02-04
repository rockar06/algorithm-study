package algorithms.easy

// https://leetcode.com/problems/two-sum/
class TwoSumSolution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val helperMap = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, item ->
            val complement = target - item
            if (helperMap[complement] == null) {
                helperMap[item] = index
            } else {
                return intArrayOf(helperMap.getOrDefault(complement, 0), index)
            }
        }
        return intArrayOf()
    }
}