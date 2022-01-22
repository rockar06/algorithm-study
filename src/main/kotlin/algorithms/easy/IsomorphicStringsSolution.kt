package algorithms.easy

// https://leetcode.com/problems/isomorphic-strings/
class IsomorphicStringsSolution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val firstMap = hashMapOf<Char, Char>()
        val secondMap = hashMapOf<Char, Char>()
        for (index in s.indices) {
            if (firstMap[s[index]] == null && secondMap[t[index]] == null) {
                firstMap[s[index]] = t[index]
                secondMap[t[index]] = s[index]
            } else if (firstMap[s[index]] != t[index]) {
                return false
            }
        }
        return true
    }
}