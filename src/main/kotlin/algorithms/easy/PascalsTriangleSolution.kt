package algorithms.easy

// https://leetcode.com/problems/pascals-triangle/submissions/
class PascalsTriangleSolution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        for (line in 0 until numRows) {
            val innerResult = arrayListOf<Int>()

            // iterate over line
            for (item in 0..line) {
                if (item == 0 || item == line) {
                    innerResult.add(1)
                } else {
                    val temp = result[line - 1]
                    val tempItem = temp[item] + temp[item - 1]
                    innerResult.add(tempItem)
                }
            }

            result.add(innerResult)
        }
        return result
    }
}
