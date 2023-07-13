package algorithms.medium

// https://leetcode.com/problems/longest-consecutive-sequence/description/
class LongestConsecutiveSequenceSolution {

    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = hashSetOf<Int>()
        nums.forEach {
            numsSet.add(it)
        }
        var result = 0

        numsSet.forEach {
            var currentNumber = it
            var currentStreak = 1
            if (!numsSet.contains(it - 1)) {
                while (numsSet.contains(currentNumber + 1)) {
                    currentNumber++
                    currentStreak++
                }
                result = Math.max(result, currentStreak)
            }
        }

        return result
    }
}