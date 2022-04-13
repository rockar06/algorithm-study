package algorithms.medium

import java.util.*

// https://leetcode.com/problems/kth-largest-element-in-an-array
class KthLargestElementInAnArraySolution {

    /*
    // Naive solution
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sort()
        return nums[nums.size - k]
    }*/

    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heapOfKValues = PriorityQueue<Int> { valueA, valueB ->
            valueA - valueB
        }
        nums.forEach {
            heapOfKValues.add(it)
            if (heapOfKValues.size > k) {
                heapOfKValues.poll()
            }
        }
        return heapOfKValues.poll()
    }
}