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

    /*fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val mapOfOccurrences = hashMapOf<Int, Int>()
        nums1.forEach {
            if (mapOfOccurrences[it] == null) {
                mapOfOccurrences[it] = 1
            } else {
                mapOfOccurrences[it] = mapOfOccurrences.getOrDefault(it, 0) + 1
            }
        }

        val resultArray = arrayListOf<Int>()

        nums2.forEach {
            if (mapOfOccurrences[it] != null && mapOfOccurrences.getOrDefault(it, 0) > 0) {
                resultArray.add(it)
                mapOfOccurrences[it] = mapOfOccurrences.getOrDefault(it, 0) - 1
            }
        }

        return resultArray.toIntArray()
    }*/
}