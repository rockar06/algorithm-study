package algorithms.easy

import java.util.*

// https://leetcode.com/problems/kth-largest-element-in-a-stream
class KthLargest(private val k: Int, nums: IntArray) {

    private val queue = PriorityQueue<Int>()

    init {
        nums.forEach {
            queue.add(it)
        }
        while (queue.size > k) {
            queue.poll()
        }
    }

    fun add(`val`: Int): Int {
        queue.add(`val`)
        if (queue.size > k) {
            queue.poll()
        }
        return queue.peek()
    }
}