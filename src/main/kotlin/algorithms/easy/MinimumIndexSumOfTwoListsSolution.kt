package algorithms.easy

// https://leetcode.com/problems/minimum-index-sum-of-two-lists
class MinimumIndexSumOfTwoListsSolution {

    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        val mapOfStringsA = hashMapOf<String, Int>()
        val mapOfStringsB = hashMapOf<String, Int>()
        list1.forEachIndexed { index, value ->
            mapOfStringsA[value] = index
        }
        list2.forEachIndexed { index, value ->
            if (mapOfStringsA[value] != null) {
                mapOfStringsB[value] = mapOfStringsA.getOrDefault(value, 0) + index
            }
        }

        var resultArray = mutableListOf<String>()
        var lastMinimumSum = -1

        mapOfStringsB.forEach {
            if (lastMinimumSum == -1 || it.value < lastMinimumSum) {
                lastMinimumSum = it.value
                resultArray = mutableListOf()
                resultArray.add(it.key)
            } else if (it.value == lastMinimumSum) {
                resultArray.add(it.key)
            }
        }

        return resultArray.toTypedArray()
    }
}