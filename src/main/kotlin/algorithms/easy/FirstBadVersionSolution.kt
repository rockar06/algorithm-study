package algorithms.easy

// https://leetcode.com/problems/first-bad-version/
class FirstBadVersionSolution {
    fun firstBadVersion(n: Int): Int {
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
    }

    fun isBadVersion(version: Int): Boolean {
        return version == 1
    }
}

fun main () {
    val result = FirstBadVersionSolution().firstBadVersion(20)
}