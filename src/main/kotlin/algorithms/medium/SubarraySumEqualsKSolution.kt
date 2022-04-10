package algorithms.medium

// https://leetcode.com/problems/subarray-sum-equals-k
class SubarraySumEqualsKSolution {

    fun subarraySum(nums: IntArray, k: Int): Int {
        var counter = 0
        var sum = 0
        val sumOccurrencesMap = hashMapOf<Int, Int>()
        sumOccurrencesMap[0] = 1
        nums.forEach {
            sum += it
            if (sumOccurrencesMap[sum - k] != null) {
                counter += sumOccurrencesMap[sum - k] ?: 0
            }
            sumOccurrencesMap[sum] = sumOccurrencesMap.getOrDefault(sum, 0) + 1
        }

        return counter
    }
}