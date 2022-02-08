package algorithms.easy

// https://leetcode.com/problems/valid-anagram/submissions/
class ValidAnagramSolution {
    /*fun isAnagram(s: String, t: String): Boolean {
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
    }*/

    fun isAnagram(s: String, t: String): Boolean {
        val firstCharMap = IntArray(26)
        val secondCharMap = IntArray(26)
        s.forEach {
            firstCharMap[it - 'a']++
        }
        t.forEach {
            secondCharMap[it - 'a']++
        }
        for (index in 0 until 26) {
            if (firstCharMap[index] != secondCharMap[index]) return false
        }
        return true
    }
}