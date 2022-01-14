package algorithms.medium

// https://leetcode.com/problems/permutation-in-string/
class PermutationInStringSolution {

    fun checkInclusion(s1: String, s2: String): Boolean {
        val charArray = IntArray(26)
        s1.forEach {
            charArray[it - 'a']++
        }

        for (firstIndex in 0..(s2.length - s1.length)) {
            val wordCharArray = IntArray(26)
            for (secondIndex in s1.indices) {
                wordCharArray[s2[firstIndex + secondIndex] - 'a']++
            }
            if (matchEveryChar(charArray, wordCharArray)) return true
        }

        return false
    }

    private fun matchEveryChar(charArray: IntArray, wordCharArray: IntArray): Boolean {
        for (index in 0 until 26) {
            if (charArray[index] != wordCharArray[index]) return false
        }
        return true
    }
}