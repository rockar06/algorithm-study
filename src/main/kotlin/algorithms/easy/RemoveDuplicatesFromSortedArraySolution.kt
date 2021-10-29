package algorithms.easy

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class RemoveDuplicatesFromSortedArraySolution {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        var indexNextGreaterNumber = 0
        var nextNumberBackup = 0
        var previousNumberBackup = 0
        while (indexNextGreaterNumber < nums.size) {
            if (nums[index] >= nums[indexNextGreaterNumber]) {
                indexNextGreaterNumber++
            } else {
                nextNumberBackup = nums[indexNextGreaterNumber]
                previousNumberBackup = nums[++index]
                nums[index] = nextNumberBackup
                nums[indexNextGreaterNumber] = previousNumberBackup
            }
        }
        return ++index
    }
}