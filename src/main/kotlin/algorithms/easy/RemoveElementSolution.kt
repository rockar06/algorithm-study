package algorithms.easy

// https://leetcode.com/problems/remove-element/
class RemoveElementSolution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        var indexNextDifferentNumber = 0
        var firstNumberBackup = 0
        var secondNumberBackup = 0
        while (indexNextDifferentNumber < nums.size) {
            indexNextDifferentNumber++
            if (nums[index] != `val`) {
                index++
            } else {
                if (indexNextDifferentNumber < nums.size && nums[indexNextDifferentNumber] != `val`) {
                    firstNumberBackup = nums[index]
                    secondNumberBackup = nums[indexNextDifferentNumber]
                    nums[index] = secondNumberBackup
                    nums[indexNextDifferentNumber] = firstNumberBackup
                    index++
                }
            }
        }
        return index
    }
}