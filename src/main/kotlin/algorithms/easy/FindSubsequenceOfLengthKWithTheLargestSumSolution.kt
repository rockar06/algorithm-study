package algorithms.easy

import java.util.PriorityQueue

// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
class FindSubsequenceOfLengthKWithTheLargestSumSolution {

   /* fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val resultQueue = PriorityQueue<Pair<Int, Int>> { firstValue, secondValue ->
            firstValue.second - secondValue.second
        }

        nums.forEachIndexed { index, item ->
            resultQueue.add(Pair(index, item))
            if (resultQueue.size > k) {
                resultQueue.poll()
            }
        }

        return resultQueue.sortedBy { it.first }.map { it.second }.toIntArray()
    }*/

    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val resultQueue = PriorityQueue<Int>()

        nums.forEach { item ->
            resultQueue.add(item)
            if (resultQueue.size > k) {
                resultQueue.poll()
            }
        }

        val result = IntArray(k)
        var counter = 0
        var resultCounter = 0
        while (resultQueue.isNotEmpty()) {
            if (resultQueue.remove(nums[counter])) {
                result[resultCounter++] = nums[counter]
            }
            counter++
        }

        return result
    }
}