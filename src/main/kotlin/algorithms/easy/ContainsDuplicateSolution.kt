package algorithms.easy

import java.util.*

// https://leetcode.com/problems/contains-duplicate/
class ContainsDuplicateSolution {

    fun containsDuplicate(nums: IntArray): Boolean {
        Arrays.sort(nums)
        nums.forEachIndexed { index, item ->
            if (index - 1 >= 0 && nums[index - 1] == item) {
                return true
            }
        }
        return false
    }

    /*fun containsDuplicate(nums: IntArray): Boolean {
        val numbersMap = hashMapOf<Int, Int>()
        nums.forEach { value ->
            numbersMap[value] = (numbersMap[value] ?: 0) + 1
            if (numbersMap[value] == null) {
                numbersMap[value] = 1
            } else {
                return true
            }
        }
        return false
    }*/

    /*fun containsDuplicate(nums: IntArray): Boolean {
        val numbersMap = hashMapOf<Int, Int>()
        nums.forEach { value ->
            numbersMap[value] = (numbersMap[value] ?: 0) + 1
        }
        numbersMap.forEach { (_, value) ->
            if (value >= 2) return true
        }
        return false
    }*/
}