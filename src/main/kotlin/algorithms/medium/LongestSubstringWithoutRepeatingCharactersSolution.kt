package algorithms.medium

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class LongestSubstringWithoutRepeatingCharactersSolution {
    fun lengthOfLongestSubstring(s: String): Int {
        var charMap = hashMapOf<Char, Int>()
        var counter = 0
        var stringIndex = 0
        var result = 0
        var secondaryIndex = 0

        while (stringIndex < s.length && secondaryIndex < s.length) {
            charMap[s[secondaryIndex]] = (charMap[s[secondaryIndex]] ?: 0) + 1
            if (charMap[s[secondaryIndex]] == 1) {
                counter++
                secondaryIndex++
            } else {
                counter = 0
                charMap.clear()
                stringIndex++
                secondaryIndex = stringIndex
            }
            result = if (counter > result) counter else result
        }

        return result
    }
}