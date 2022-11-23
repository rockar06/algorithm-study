package algorithms.medium

class FindFirstAndLastPositionOfElementInSortedArraySolution {

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var leftPointer = 0
        var rightPointer = nums.size - 1

        while (leftPointer < rightPointer) {
            val pivot = leftPointer + (rightPointer - leftPointer) / 2

            if (nums[pivot] >= target) {
                rightPointer = pivot
            } else {
                leftPointer = pivot + 1
            }
        }

        val firstPosition = rightPointer

        leftPointer = rightPointer
        rightPointer = nums.size - 1

        while (leftPointer <= rightPointer) {
            val pivot = leftPointer + (rightPointer - leftPointer) / 2

            if (pivot < 0 || pivot > nums.size) {
                return intArrayOf(-1, -1)
            }

            if (nums[pivot] == target) {
                leftPointer = pivot + 1
            } else {
                rightPointer = pivot - 1
            }
        }


        return if (firstPosition > rightPointer) {
            intArrayOf(-1, -1)
        } else {
            intArrayOf(firstPosition, rightPointer)
        }
    }
}