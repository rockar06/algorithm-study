package algorithms.easy

import java.util.*

// https://leetcode.com/problems/intersection-of-two-arrays-ii
class IntersectionOfTwoArraysIISolution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        var result = intArrayOf()
        Arrays.sort(nums1)
        Arrays.sort(nums2)
        var firstCounter = 0
        var secondCounter = 0
        while (firstCounter < nums1.size && secondCounter < nums2.size) {
            if (nums1[firstCounter] == nums2[secondCounter]) {
                result = result.plus(nums1[firstCounter])
                firstCounter++
                secondCounter++
            } else if (nums1[firstCounter] > nums2[secondCounter]) {
                secondCounter++
            } else {
                firstCounter++
            }
        }
        return result
    }
}