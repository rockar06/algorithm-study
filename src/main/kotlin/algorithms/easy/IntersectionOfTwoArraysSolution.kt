package algorithms.easy

// https://leetcode.com/problems/intersection-of-two-arrays
class IntersectionOfTwoArraysSolution {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val integerMapper = hashSetOf<Int>()
        val intersectionArray = arrayListOf<Int>()

        nums1.forEach {
            integerMapper.add(it)
        }

        nums2.forEach {
            if (integerMapper.contains(it)) {
                intersectionArray.add(it)
                integerMapper.remove(it)
            }
        }
        return intersectionArray.toIntArray()
    }
}