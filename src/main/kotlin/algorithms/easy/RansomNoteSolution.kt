package algorithms.easy

// https://leetcode.com/problems/ransom-note
class RansomNoteSolution {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val charMapper = IntArray(26)
        magazine.forEach {
            charMapper[it - 'a']++
        }
        var matchCounter = 0
        ransomNote.forEach {
            if (charMapper[it - 'a'] != 0) {
                charMapper[it - 'a']--
                matchCounter++
            }
        }
        return matchCounter == ransomNote.length
    }
}