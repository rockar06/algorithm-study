package algorithms.medium

// https://leetcode.com/problems/maximum-swap
class MaximumSwapSolution {

    fun maximumSwap(num: Int): Int {
        val numString = StringBuilder(num.toString())
        var leftPointer = 0
        var rightPointer = numString.lastIndex
        var tempMaxValue = 0
        var tempMaxIndex = 0

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer) {
                if (numString[rightPointer].digitToInt() > tempMaxValue) {
                    tempMaxValue = numString[rightPointer].digitToInt()
                    tempMaxIndex = rightPointer
                }
                rightPointer--
            }
            if (numString[leftPointer].digitToInt() < numString[tempMaxIndex].digitToInt()) {
                val temp = numString[leftPointer]
                numString[leftPointer] = numString[tempMaxIndex]
                numString[tempMaxIndex] = temp
                return numString.toString().toInt()
            }
            tempMaxValue = 0
            rightPointer = numString.lastIndex
            leftPointer++
        }
        return numString.toString().toInt()
    }
}

fun main() {
    MaximumSwapSolution().maximumSwap(9973)
}