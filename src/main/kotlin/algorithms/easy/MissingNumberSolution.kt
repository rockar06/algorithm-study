package algorithms.easy

// https://leetcode.com/problems/missing-number/
class MissingNumberSolution {
    /*fun missingNumber(nums: IntArray): Int {
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
    }*/
    fun missingNumber(nums: IntArray): Int {
        val numberMapper = IntArray(nums.size + 1) { index ->
            index
        }
        nums.forEach { item ->
            numberMapper[item] = -1
        }
        numberMapper.forEach { item ->
            if (item != -1) return item
        }
        return 0
    }
}