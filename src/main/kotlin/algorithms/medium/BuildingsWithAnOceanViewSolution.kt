package algorithms.medium

import java.util.*

// https://leetcode.com/problems/buildings-with-an-ocean-view/
class BuildingsWithAnOceanViewSolution {

    fun findBuildings(heights: IntArray): IntArray {
        val stackOfBuilds = Stack<Int>()
        heights.forEachIndexed { index, item ->
            if (stackOfBuilds.isEmpty()) {
                stackOfBuilds.push(index)
            } else {
                while (stackOfBuilds.isNotEmpty() && heights[stackOfBuilds.peek()] <= item) {
                    stackOfBuilds.pop()
                }
                stackOfBuilds.push(index)
            }
        }
        return stackOfBuilds.toIntArray()
    }
}