package algorithms.medium

// https://leetcode.com/problems/merge-intervals/
class MergeIntervalsSolution {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy {
            it.first()
        }
        var completed = false
        var result = intervals

        while (completed.not()) {
            completed = true
            val tempArray = arrayListOf<IntArray>()
            result.forEach {
                if (tempArray.isNotEmpty() && tempArray.last().last() >= it.first() &&
                    tempArray.last().first() <= it.last()
                ) {
                    val temp = tempArray.removeAt(tempArray.lastIndex)
                    tempArray.add(
                        intArrayOf(
                            Math.min(temp.first(), it.first()),
                            Math.max(temp.last(), it.last())
                        )
                    )
                    completed = false
                } else {
                    tempArray.add(it)
                }
            }
            result = tempArray.toTypedArray()
        }

        return result
    }
}