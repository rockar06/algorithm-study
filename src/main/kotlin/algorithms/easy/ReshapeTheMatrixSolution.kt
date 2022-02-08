package algorithms.easy

// https://leetcode.com/problems/reshape-the-matrix
class ReshapeTheMatrixSolution {

    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        val tempArray = arrayListOf<Int>()
        mat.forEach { row ->
            row.forEach { column ->
                tempArray.add(column)
            }
        }
        if (tempArray.size / r == 0 || tempArray.size / c != r) {
            return mat
        }
        val totalItemsPerRow = tempArray.size / r
        var rowArray = IntArray(totalItemsPerRow)
        var counter = 0
        tempArray.forEach { item ->
            rowArray[counter++] = item
            if (counter >= totalItemsPerRow) {
                result.add(rowArray)
                counter = 0
                rowArray = IntArray(totalItemsPerRow)
            }
        }

        return result.toTypedArray()
    }
}