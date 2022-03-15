package algorithms.easy

// https://leetcode.com/problems/toeplitz-matrix/
class ToeplitzMatrixSolution {

    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        matrix.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, item ->
                if (rowIndex > 0 && columnIndex > 0 && matrix[rowIndex - 1][columnIndex - 1] != item) {
                    return false
                }
            }
        }
        return true
    }
}