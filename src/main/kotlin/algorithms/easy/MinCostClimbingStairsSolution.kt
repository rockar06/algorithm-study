package algorithms.easy

// https://leetcode.com/problems/min-cost-climbing-stairs/
class MinCostClimbingStairsSolution {

    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost.size == 1) return cost.first()
        val resultArray = IntArray(cost.size)
        resultArray[0] = cost.first()
        resultArray[1] = cost[1]

        for (index in 2 until cost.size) {
            resultArray[index] = Math.min(resultArray[index - 1], resultArray[index - 2]) + cost[index]
        }

        return Math.min(resultArray.last(), resultArray[resultArray.size - 2])
    }
}