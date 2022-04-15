package algorithms.easy

// https://leetcode.com/problems/get-maximum-in-generated-array/
class GetMaximumInGeneratedArraySolution {

    fun getMaximumGenerated(n: Int): Int {
        if (n <= 1) return n
        val arrayOfCalculatedValues = arrayListOf<Int>()
        arrayOfCalculatedValues.add(0)
        arrayOfCalculatedValues.add(1)
        var maxValueResult = arrayOfCalculatedValues.component2()
        var index = 1
        while (arrayOfCalculatedValues.size <= n) {
            val currentValueToCompare = if (arrayOfCalculatedValues.size % 2 == 0) {
                arrayOfCalculatedValues.add(index * 2, arrayOfCalculatedValues[index])
                arrayOfCalculatedValues[(index * 2)]
            } else {
                arrayOfCalculatedValues.add(
                    (index * 2) + 1,
                    arrayOfCalculatedValues[index] + arrayOfCalculatedValues[index + 1]
                )
                arrayOfCalculatedValues[(index++ * 2) + 1]
            }
            maxValueResult = Math.max(maxValueResult, currentValueToCompare)
        }
        return maxValueResult
    }
}