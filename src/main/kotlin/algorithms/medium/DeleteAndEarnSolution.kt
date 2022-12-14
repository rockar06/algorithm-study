package algorithms.medium

// https://leetcode.com/problems/delete-and-earn
class DeleteAndEarnSolution {

    private val pointsMapper = hashMapOf<Int, Int>()
    private val cacheOfPoints = hashMapOf<Int, Int>()

    fun deleteAndEarn(nums: IntArray): Int {
        var maxNumber = 0

        nums.forEach { number ->
            pointsMapper[number] = pointsMapper.getOrDefault(number, 0) + number
            maxNumber = Math.max(maxNumber, number)
        }

        return maxPoints(maxNumber)
    }

    private fun maxPoints(number: Int): Int {
        return if (number == 0) {
            0
        } else if (number == 1) {
            pointsMapper.getOrDefault(1, 0)
        } else if (cacheOfPoints[number] != null) {
            cacheOfPoints.getOrDefault(number, 0)
        } else {
            val gainValue = pointsMapper.getOrDefault(number, 0)
            cacheOfPoints[number] = Math.max(maxPoints(number - 1), maxPoints(number - 2) + gainValue)
            return cacheOfPoints.getOrDefault(number, 0)
        }
    }
}