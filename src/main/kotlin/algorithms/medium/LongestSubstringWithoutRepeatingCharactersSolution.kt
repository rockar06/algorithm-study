package algorithms.medium

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class LongestSubstringWithoutRepeatingCharactersSolution {

    fun lengthOfLongestSubstring(s: String): Int {
        val charMapping = hashMapOf<Char, Int>()
        var leftPointer = 0
        var rightPointer = 0
        var result = 0

        while (rightPointer < s.length) {
            // Get the char from right pointer
            val rightChar = s[rightPointer]
            // Add value to map and increase the number of coincidences
            charMapping[rightChar] = charMapping.getOrDefault(rightChar, 0) + 1

            // If charMapping[rightChar] is greater than 1 iterate until we get only 1
            while (charMapping.getOrDefault(rightChar, 0) > 1) {
                val charLeft = s[leftPointer]
                charMapping[charLeft] = charMapping.getOrDefault(charLeft, 1) - 1
                leftPointer++
            }
            result = Math.max(result, rightPointer - leftPointer + 1)

            rightPointer++
        }

        return result
    }
}