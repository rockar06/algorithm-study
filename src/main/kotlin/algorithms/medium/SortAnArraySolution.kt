package algorithms.medium

// https://leetcode.com/problems/sort-an-array/
class SortAnArraySolution {

    fun sortArray(nums: IntArray): IntArray {
        return mergeSort(nums, 0, nums.size - 1)
    }

    private fun mergeSort(arrayToSort: IntArray, leftPointer: Int, rightPointer: Int): IntArray {
        if (leftPointer == rightPointer) {
            return intArrayOf(arrayToSort[leftPointer])
        }
        val middlePoint = (leftPointer + rightPointer) / 2

        val leftOrderedArray = mergeSort(arrayToSort, leftPointer, middlePoint)
        val rightOrderedArray = mergeSort(arrayToSort, middlePoint + 1, rightPointer)

        return mergeTwoOrderedArrays(leftOrderedArray, rightOrderedArray)
    }

    private fun mergeTwoOrderedArrays(firstArray: IntArray, secondArray: IntArray): IntArray {

        val sortedArray = IntArray(firstArray.size + secondArray.size)

        var firstIndex = 0
        var secondIndex = 0
        var sortedIndex = 0

        while (firstIndex < firstArray.size && secondIndex < secondArray.size) {
            if (firstArray[firstIndex] < secondArray[secondIndex]) {
                sortedArray[sortedIndex] = firstArray[firstIndex]
                firstIndex++
                sortedIndex++
            } else {
                sortedArray[sortedIndex] = secondArray[secondIndex]
                secondIndex++
                sortedIndex++
            }
        }

        if (firstIndex == firstArray.size) {
            while (secondIndex < secondArray.size) {
                sortedArray[sortedIndex] = secondArray[secondIndex]
                secondIndex++
                sortedIndex++
            }
        }

        if (secondIndex == secondArray.size) {
            while (firstIndex < firstArray.size) {
                sortedArray[sortedIndex] = firstArray[firstIndex]
                firstIndex++
                sortedIndex++
            }
        }

        return sortedArray
    }

}