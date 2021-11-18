package algorithms.easy

// https://leetcode.com/problems/merge-sorted-array/
class MergeSortedArraySolution {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        if (n == 0) {
            return
        }

        // Merge the two arrays
        val totalSize = m + n
        var insertIndex = m
        var indexNums2 = 0
        while (insertIndex < totalSize) {
            nums1[insertIndex++] = nums2[indexNums2++]
        }
        if (m == 0) {
            return
        }
        // Once merged, sort the nums1
        sort(nums1, totalSize)
    }

    private fun sort(originalArray: IntArray, totalSize: Int) {
        if (totalSize < 2) {
            return
        }
        val middle = totalSize / 2
        val rightSize = totalSize - middle
        val leftArray = IntArray(middle)
        val rightArray = IntArray(rightSize)

        // Copy first segment
        for (i in 0 until middle) {
            leftArray[i] = originalArray[i]
        }

        // Copy second segment
        for (i in middle until totalSize) {
            rightArray[i - middle] = originalArray[i]
        }

        sort(leftArray, middle)
        sort(rightArray, rightSize)
        merge(originalArray, leftArray, rightArray, middle, rightSize)
    }

    private fun merge(
        originalArray: IntArray,
        leftArray: IntArray,
        rightArray: IntArray,
        leftSize: Int,
        rightSize: Int
    ) {
        var indexLeft = 0
        var indexRight = 0
        var index = 0

        while (indexLeft < leftSize && indexRight < rightSize) {
            originalArray[index++] = if (leftArray[indexLeft] <= rightArray[indexRight]) {
                leftArray[indexLeft++]
            } else {
                rightArray[indexRight++]
            }
        }

        while (indexLeft < leftSize) {
            originalArray[index++] = leftArray[indexLeft++]
        }
        while (indexRight < rightSize) {
            originalArray[index++] = rightArray[indexRight++]
        }
    }
}