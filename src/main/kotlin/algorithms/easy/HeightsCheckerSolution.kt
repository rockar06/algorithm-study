package algorithms.easy

// https://leetcode.com/problems/height-checker
class HeightsCheckerSolution {
    fun heightChecker(heights: IntArray): Int {
        var counter = 0
        val sortedArray = heights.sortedArray()
        for (index in heights.indices) {
            if (heights[index] != sortedArray[index]) {
                counter++
            }
        }
        return counter
    }
}