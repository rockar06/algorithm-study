package algorithms.easy

// https://leetcode.com/problems/majority-element/
class MajorityElementSolution {
    fun majorityElement(nums: IntArray): Int {
        var result = 0
        val numbersMap = hashMapOf<Int, Int>()
        nums.forEach {
            numbersMap[it] = (numbersMap[it] ?: 0) + 1
        }
        numbersMap.forEach { (key, value) ->
            if (value > (numbersMap[result] ?: 0)) result = key
        }
        return result
    }
}