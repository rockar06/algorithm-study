package algorithms.medium

// https://leetcode.com/problems/search-a-2d-matrix
class SearchA2DMatrixSolution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        matrix.forEach {
            if (target <= it.last()) {
                return searchForTargetInRow(it, target)
            }
        }
        return false
    }

    private fun searchForTargetInRow(rowArray: IntArray, target: Int): Boolean {
        var lowIndex = 0
        var highIndex = rowArray.size - 1
        while (lowIndex <= highIndex) {
            val middle = (highIndex + lowIndex) / 2
            if (rowArray[middle] < target) {
                lowIndex = middle + 1
            } else if (rowArray[middle] > target) {
                highIndex = middle - 1
            } else {
                return true
            }
        }
        return false
    }
}