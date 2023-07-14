package algorithms.medium

import java.util.*

// https://leetcode.com/problems/merge-intervals/
class MergeIntervalsSolution {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy {
            it.first()
        }

        val result = LinkedList<IntArray>()

        intervals.forEach {
            if (result.isEmpty() || result.last.last() < it.first()) {
                result.add(it)
            } else {
                result.last[1] = Math.max(result.last.last(), it.last())
            }
        }

        return result.toTypedArray()
    }
}