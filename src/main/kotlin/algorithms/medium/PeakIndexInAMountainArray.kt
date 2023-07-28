package algorithms.medium

// https://leetcode.com/problems/peak-index-in-a-mountain-array
class PeakIndexInAMountainArray {

    fun peakIndexInMountainArray(arr: IntArray, leftIndex: Int = 0, rightIndex: Int = arr.lastIndex, addedMiddle: Int = 0): Int {
        if (leftIndex == rightIndex) return leftIndex
        val middle = (rightIndex + addedMiddle) / 2
        return if (arr[middle] > arr.getOrElse(middle - 1) { 0 } && arr[middle] > arr.getOrElse(middle + 1) { 0 }) {
            middle
        } else if (arr.getOrNull(middle - 1) != null && arr[middle - 1] > arr[middle]) {
            peakIndexInMountainArray(arr, leftIndex, middle - 1)
        } else {
            peakIndexInMountainArray(arr, middle + 1, rightIndex, middle)
        }
    }
}