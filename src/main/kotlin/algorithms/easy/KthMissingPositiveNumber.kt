package algorithms.easy

// https://leetcode.com/problems/kth-missing-positive-number
class KthMissingPositiveNumber {

    fun findKthPositive(arr: IntArray, k: Int): Int {
        var leftPointer = 0
        var rightPointer = arr.size - 1

        while (leftPointer <= rightPointer) {
            val pivot = leftPointer + (rightPointer - leftPointer) / 2
            if (arr[pivot] - (pivot + 1) < k) {
                leftPointer = pivot + 1
            } else {
                rightPointer = pivot - 1
            }
        }

        return leftPointer + k
    }
}

fun main() {
    val result = KthMissingPositiveNumber().findKthPositive(intArrayOf(2,3,4,7,11), 5)
    result
}