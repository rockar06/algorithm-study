package algorithms.medium

// https://leetcode.com/problems/3sum
class ThreeSumSolution {

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        var numsIndex = 0

        while (numsIndex < nums.size && nums[numsIndex] <= 0) {
            if (numsIndex == 0 || nums[numsIndex - 1] != nums[numsIndex]) {
                twoSum(nums, numsIndex, result)
            }
            numsIndex++
        }

        return result
    }

    fun twoSum(numbers: IntArray, index: Int, result: MutableList<List<Int>>) {
        var leftPointer = index + 1
        var rightPointer = numbers.lastIndex

        while (leftPointer < rightPointer) {
            val currentSum = numbers[index] + numbers[leftPointer] + numbers[rightPointer]
            if (currentSum < 0) {
                leftPointer++
            } else if (currentSum > 0) {
                rightPointer--
            } else {
                result.add(arrayListOf(numbers[index], numbers[leftPointer++], numbers[rightPointer--]))
                while (leftPointer < rightPointer && numbers[leftPointer] == numbers[leftPointer - 1]) {
                    ++leftPointer
                }
            }
        }
    }
}