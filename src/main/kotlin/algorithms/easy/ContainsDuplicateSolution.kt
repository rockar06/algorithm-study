package algorithms.easy

import java.util.*

// https://leetcode.com/problems/contains-duplicate/
class ContainsDuplicateSolution {

    fun containsDuplicate(nums: IntArray): Boolean {
        val numbersMap = hashSetOf<Int>()
        nums.forEach {
            if (numbersMap.contains(it)) {
                return true
            }
            numbersMap.add(it)
        }
        return false
    }
}