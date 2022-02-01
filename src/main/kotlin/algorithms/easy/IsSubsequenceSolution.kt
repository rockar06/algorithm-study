package algorithms.easy

// https://leetcode.com/problems/is-subsequence
class IsSubsequenceSolution {

    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        if (t.isEmpty()) return false
        var counter = 0
        t.forEach {
            if (s[counter] == it) {
                counter++
            }
            if (counter == s.length) return true
        }
        return false
    }
}