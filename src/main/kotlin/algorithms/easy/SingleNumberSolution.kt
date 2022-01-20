package algorithms.easy

// https://leetcode.com/problems/single-number/
class SingleNumberSolution {

    fun singleNumber(nums: IntArray): Int {
        var result = nums.first()
        for (index in 0 until nums.size - 1) {
            result = result xor nums[index + 1]
        }
        return result
    }

    /*fun singleNumber(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()
        val numberMap = hashMapOf<Int, Int>()
        nums.forEach {
            numberMap[it] = (numberMap[it] ?: 0) + 1
        }
        numberMap.forEach { (key, value) ->
            if (value == 1) return key
        }
        return 0
    }*/
}