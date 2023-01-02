package algorithms.easy

// https://leetcode.com/problems/remove-element/
class RemoveElementSolution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var leftPointer = 0
        var rightPointer = nums.lastIndex
        while (leftPointer <= rightPointer) {
            if (nums[leftPointer] == `val`) {
                if (nums[rightPointer] != `val`) {
                    val tempValue = nums[leftPointer]
                    nums[leftPointer++] = nums[rightPointer]
                    nums[rightPointer--] = tempValue
                } else {
                    rightPointer--
                }
            } else {
                leftPointer++
            }
        }
        return leftPointer
    }
}