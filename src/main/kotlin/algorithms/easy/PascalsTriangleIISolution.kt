package algorithms.easy

// https://leetcode.com/problems/pascals-triangle-ii/
class PascalsTriangleIISolution {
    fun getRow(rowIndex: Int): List<Int> {
        var result = arrayListOf<Int>()
        for (line in 0..rowIndex) {
            val tempArray = arrayListOf<Int>()
            for (item in 0..line) {
                if (item == 0 || item == line) {
                    tempArray.add(1)
                } else {
                    val newItem = result[item] + result[item - 1]
                    tempArray.add(newItem)
                }
            }
            result = tempArray
        }
        return result
    }
}