package algorithms.easy

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class TwoSumIISolution {
    /*fun twoSum(numbers: IntArray, target: Int): IntArray {
        val resultArray = IntArray(2)
        numbers.forEachIndexed { index, item ->
            val secondIndex = findSecondIndex(numbers, target - item, index + 1, numbers.size - 1)
            if (secondIndex != index && secondIndex != -1) {
                resultArray[0] = index + 1
                resultArray[1] = secondIndex + 1
                return resultArray
            }
        }
        return resultArray
    }

    private fun findSecondIndex(nums: IntArray, target: Int, min: Int, max: Int): Int {
        val middle = ((max - min) / 2) + min
        return when {
            min > max -> return -1
            target > nums[middle] -> findSecondIndex(nums, target, middle + 1, max)
            target == nums[middle] -> return middle
            target < nums[middle] -> findSecondIndex(nums, target, min, middle - 1)
            else -> throw IllegalStateException()
        }
    }*/
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var lowIndex = 0
        var highIndex = numbers.size - 1
        while (lowIndex < highIndex) {
            val result = numbers[lowIndex] + numbers[highIndex]
            if (result == target) {
                return intArrayOf(lowIndex + 1, highIndex + 1)
            } else if (result < target) {
                lowIndex++
            } else {
                highIndex--
            }
        }
        return intArrayOf()
    }
}