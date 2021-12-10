package algorithms.easy

// https://leetcode.com/problems/pascals-triangle/submissions/
class PascalsTriangleSolution {

    fun generate(numRows: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        var tempArray = arrayListOf<Int>()
        var levelIndex = 0
        var rowIndex = 0
        var counter = 0

        while (levelIndex < numRows) {
            counter++
            if (rowIndex == 0 || rowIndex == levelIndex) {
                tempArray.add(1)
            } else {
                val temp = result[levelIndex - 1]
                val tempItem = temp[rowIndex] + temp[rowIndex - 1]
                tempArray.add(tempItem)
            }

            if (rowIndex < levelIndex) {
                rowIndex++
            } else {
                levelIndex++
                rowIndex = 0
                result.add(tempArray)
                tempArray = arrayListOf()
            }
        }
        return result
    }


/*    fun generate(numRows: Int): List<List<Int>> {
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
    }*/
}
