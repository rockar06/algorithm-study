package algorithms.easy

// https://leetcode.com/problems/intersection-of-two-arrays
class IntersectionOfTwoArraysSolution {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val integerMapper = hashMapOf<Int, Boolean>()
        val intersectionArray = mutableSetOf<Int>()

        nums1.forEach {
            integerMapper[it] = true
        }

        nums2.forEach {
            if (integerMapper[it] == true) {
                intersectionArray.add(it)
            }
        }
        return intersectionArray.toIntArray()
    }
}