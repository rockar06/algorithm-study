package algorithms.easy

// https://leetcode.com/problems/valid-anagram/submissions/
class ValidAnagramSolution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val charMap = hashMapOf<Char, Int>()
        s.forEach {
            charMap[it] = (charMap[it] ?: 0) + 1
        }
        t.forEach {
            charMap[it] = (charMap[it] ?: 0) - 1
        }
        for (value in charMap.values) {
            if (value != 0) return false
        }
        return true
    }
}