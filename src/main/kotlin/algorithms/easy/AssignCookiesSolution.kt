package algorithms.easy

// https://leetcode.com/problems/assign-cookies/
class AssignCookiesSolution {

    fun findContentChildren(g: IntArray, s: IntArray): Int {
        var childCounter = 0
        var index = 0
        val minSize = Math.min(g.size, s.size)
        while (index < minSize) {
            if (s[index] >= g[index]) {
                childCounter++
            }
            index++
        }
        return childCounter
    }
}