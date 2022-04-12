package algorithms.easy

// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays
class ReverseToMakeEqualSolution {
    /*fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        // sort target
        target.sort()
        // sort arr
        arr.sort()
        for (index in target.indices) {
            // compare target and arr, if there is a different number, return false
            if (target[index] != arr[index]) return false
        }
        // By default return true
        return false
    }*/

    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val mapContainerOfTarget = hashMapOf<Int, Int>()
        target.forEach {
            mapContainerOfTarget[it] = mapContainerOfTarget.getOrDefault(it, 0) + 1
        }
        arr.forEach {
            if (mapContainerOfTarget.getOrDefault(it, 0) == 1) {
                mapContainerOfTarget.remove(it)
            } else {
                mapContainerOfTarget[it] = mapContainerOfTarget.getOrDefault(it, 0) - 1
            }
        }
        return mapContainerOfTarget.isEmpty()
    }
}