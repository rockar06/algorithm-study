package algorithms.easy

// https://leetcode.com/problems/missing-number/
class MissingNumberSolution {
    fun missingNumber(nums: IntArray): Int {
        val numberMap = hashMapOf<Int, Int>()
        for (i in 0..nums.size) {
            numberMap[i] = 0
        }
        nums.forEach {
            numberMap[it] = 1
        }
        numberMap.forEach { (key, value) ->
            if (value == 0) {
                return key
            }
        }
        return 0
    }
}