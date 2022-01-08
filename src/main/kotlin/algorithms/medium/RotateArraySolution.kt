package algorithms.medium

// https://leetcode.com/problems/rotate-array/
class RotateArraySolution {
    fun rotate(nums: IntArray, k: Int) {
        var counter = 0
        var countDown: Int
        var tempValue: Int
        while (counter < k) {
            tempValue = nums.last()
            countDown = nums.size - 1
            while (countDown > 0) {
                nums[countDown] = nums[countDown - 1]
                countDown--
            }
            nums[0] = tempValue
            counter++
        }
    }
}