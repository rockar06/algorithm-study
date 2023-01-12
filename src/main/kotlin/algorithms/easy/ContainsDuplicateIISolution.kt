package algorithms.easy

// https://leetcode.com/problems/contains-duplicate-ii/submissions/
class ContainsDuplicateIISolution {

    /*fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (k == 0 && nums.size == 1) return false
        var leftPointer = 0
        var rightPointer = 1
        while (leftPointer < nums.size - 1) {
            if (Math.abs(leftPointer - rightPointer) <= k &&
                nums[leftPointer] == nums[rightPointer]
            ) {
                return true
            }
            rightPointer = if (rightPointer + 1 >= nums.size) {
                nums.lastIndex
            } else {
                rightPointer + 1
            }
            if (Math.abs(leftPointer - rightPointer) > k) {
                leftPointer++
                rightPointer = leftPointer + 1
            }
        }
        return false
    }*/

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val mapSetOfValues = hashSetOf<Int>()
        nums.forEachIndexed { index, item ->
            if (mapSetOfValues.contains(item)) return true
            mapSetOfValues.add(item)
            if (mapSetOfValues.size > k) {
                mapSetOfValues.remove(nums[index - k])
            }
        }
        return false
    }

    /*fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val numbersMapper = hashMapOf<Int, Int>()

        nums.forEachIndexed { index, value ->
            if (numbersMapper[value] == null) {
                numbersMapper[value] = index
            } else {
                val lastIndex = numbersMapper.getOrDefault(value, 0)
                val absoluteResult = Math.abs(lastIndex - index)
                if (absoluteResult <= k) {
                    return true
                } else {
                    numbersMapper[value] = index
                }
            }
        }

        return false
    }*/
}