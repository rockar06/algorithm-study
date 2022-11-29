package algorithms.medium

// https://leetcode.com/problems/container-with-most-water/
class ContainerWithMostWaterSolution {

    fun maxArea(height: IntArray): Int {
        var leftPointer = 0
        var rightPointer = height.size - 1
        var factor: Int
        var result = 0

        while (leftPointer < rightPointer) {
            factor = rightPointer - leftPointer
            val maxHeight = Math.min(height[leftPointer], height[rightPointer])
            result = Math.max(result, maxHeight * factor)

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++
            } else {
                rightPointer--
            }
        }

        return result
    }
}