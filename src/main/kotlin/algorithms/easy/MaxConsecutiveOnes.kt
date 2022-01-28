package algorithms.easy

// https://leetcode.com/problems/max-consecutive-ones
class MaxConsecutiveOnes {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxCounter = 0
        var currentCounter = 0
        nums.forEach {
            if (it == 1) {
                currentCounter++
            } else {
                maxCounter = Math.max(maxCounter, currentCounter)
                currentCounter = 0
            }
        }
        return maxCounter
    }
}