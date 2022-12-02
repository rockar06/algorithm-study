package algorithms.medium

// https://leetcode.com/problems/diagonal-traverse
class DiagonalTraverseSolution {

    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        // Set variables to track the size of the matrix
        val rowSize = mat.size
        val columnSize = mat.first().size

        // Result array is the size pf columnSize * rowSize
        val result = IntArray(rowSize * columnSize)
        var resultIndex = 0

        // Keep track of each diagonal in the matrix
        val diagonalHelper = arrayListOf<Int>()

        // Iterate over firs and last row to be sure we iterate over all diagonals
        for (diagonalIndex in 0 until (rowSize + columnSize - 1)) {

            // Clear the diagonalHelper to store next diagonal
            diagonalHelper.clear()

            // Get heads of each diagonal in the first row
            var rowIndex = if (diagonalIndex < columnSize) 0 else diagonalIndex - columnSize + 1
            var columnIndex = if (diagonalIndex < columnSize) diagonalIndex else columnSize - 1

            // Iterate until one index is out of the bounds
            while (rowIndex < rowSize && columnIndex > -1) {
                diagonalHelper.add(mat[rowIndex++][columnIndex--])
            }

            // Reverse for odd numbered diagonals
            if (diagonalIndex % 2 == 0) {
                diagonalHelper.reverse()
            }

            // Add items to the result
            diagonalHelper.forEach { item ->
                result[resultIndex++] = item
            }
        }

        return result
    }
}

fun main() {
    /*val test = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )*/
    /*val test = arrayOf(
        intArrayOf(1)
    )*/
    val test = arrayOf(
        intArrayOf(2,3)
    )
    val result = DiagonalTraverseSolution().findDiagonalOrder(test)
    result
}