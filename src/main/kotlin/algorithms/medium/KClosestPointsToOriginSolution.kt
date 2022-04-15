package algorithms.medium

import java.util.*

// https://leetcode.com/problems/k-closest-points-to-origin/submissions/
class KClosestPointsToOriginSolution {

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val queueOfCloserItems = PriorityQueue<Pair<Double, IntArray>> { itemA, itemB ->
            itemB.first.compareTo(itemA.first)
        }
        points.forEach {
            queueOfCloserItems.add(calculateDistanceToOrigin(it))
            if (queueOfCloserItems.size > k) {
                queueOfCloserItems.poll()
            }
        }
        return queueOfCloserItems.map {
            it.second
        }.toTypedArray()
    }

    private fun calculateDistanceToOrigin(point: IntArray): Pair<Double, IntArray> {
        val firstValue = point.component1() * point.component1()
        val secondValue = point.component2() * point.component2()
        val result = Math.sqrt((firstValue + secondValue).toDouble())
        return Pair(result, point)
    }
}