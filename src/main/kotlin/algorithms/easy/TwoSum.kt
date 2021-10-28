package algorithms.easy

// https://leetcode.com/problems/two-sum/
class TwoSumSolution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val auxiliaryMap = HashMap<Int, Int>()
        nums.forEachIndexed { index, value ->
            if (auxiliaryMap.containsKey(target - value)) {
                val firstIndex = auxiliaryMap[target - value]!!
                return intArrayOf(firstIndex, index)
            }
            auxiliaryMap[value] = index
        }
        return intArrayOf()
    }
}