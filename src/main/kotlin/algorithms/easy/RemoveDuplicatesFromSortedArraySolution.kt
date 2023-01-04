package algorithms.easy

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class RemoveDuplicatesFromSortedArraySolution {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 1) return 1
        var leftPointer = 0
        var rightPointer = 1

        while (rightPointer < nums.size) {
            if (nums[leftPointer] != nums[rightPointer]) {
                nums[++leftPointer] = nums[rightPointer++]
            } else {
                rightPointer++
            }
        }

        return leftPointer + 1
    }
}