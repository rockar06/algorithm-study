package algorithms.easy

// https://leetcode.com/problems/first-bad-version/
class FirstBadVersionSolution {
    /*fun firstBadVersion(n: Int): Int {
        return findBadVersion(1, n)
    }

    private fun findBadVersion(min: Int, max: Int): Int {
        if (min == max || (isBadVersion(max) && !isBadVersion(max - 1))) return max
        val middle = ((max - min) / 2) + min
        return if (isBadVersion(middle) && !isBadVersion(middle - 1)) {
            middle
        } else if (isBadVersion(middle) && isBadVersion(middle - 1)) {
            findBadVersion(min, middle)
        } else {
            findBadVersion(middle, max)
        }
    }*/

    fun firstBadVersion(n: Int): Int {
        var leftPointer = 1
        var rightPointer = n
        while (leftPointer < rightPointer) {
            val pivot = leftPointer + (rightPointer - leftPointer) / 2

            if (isBadVersion(pivot)) {
                rightPointer = pivot
            } else {
                leftPointer = pivot + 1
            }
        }
        return rightPointer
    }

    fun isBadVersion(version: Int): Boolean {
        return version == 1
    }
}
