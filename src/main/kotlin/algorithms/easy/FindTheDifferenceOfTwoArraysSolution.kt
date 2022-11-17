package algorithms.easy

// https://leetcode.com/problems/find-the-difference-of-two-arrays
class FindTheDifferenceOfTwoArraysSolution {

    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        return listOf(getDifferenceList(nums1, nums2), getDifferenceList(nums2, nums1))
    }

    private fun getDifferenceList(baseArray: IntArray, mapperArray: IntArray): List<Int> {
        val differenceMapper = hashMapOf<Int, Boolean>()
        val differenceArray = mutableSetOf<Int>()

        mapperArray.forEach {
            differenceMapper[it] = true
        }

        baseArray.forEach {
            if (differenceMapper[it] != true) {
                differenceArray.add(it)
            }
        }

        return differenceArray.toList()
    }
}