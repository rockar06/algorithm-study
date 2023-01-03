package algorithms.easy

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class TwoSumIISolution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var leftPointer = 0
        var rightPointer = numbers.lastIndex
        while (leftPointer < rightPointer) {
            val currentSum = numbers[leftPointer] + numbers[rightPointer]
            if (currentSum < target) {
                leftPointer++
            } else if (currentSum > target) {
                rightPointer--
            } else {
                return intArrayOf(leftPointer + 1, rightPointer + 1)
            }
        }
        return intArrayOf()
    }
}