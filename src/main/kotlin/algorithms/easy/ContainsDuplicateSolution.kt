package algorithms.easy

// https://leetcode.com/problems/contains-duplicate/
class ContainsDuplicateSolution {

    fun containsDuplicate(nums: IntArray): Boolean {
        val numbersMap = hashMapOf<Int, Int>()
        nums.forEach { value ->
            numbersMap[value] = (numbersMap[value] ?: 0) + 1
        }
        numbersMap.forEach { (_, value) ->
            if (value >= 2) return true
        }
        return false
    }
}