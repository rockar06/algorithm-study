package algorithms.easy

import kotlin.text.StringBuilder

// https://leetcode.com/problems/reverse-vowels-of-a-string
class ReverseVowelsOfAStringSolution {
    fun reverseVowels(s: String): String {
        var leftIndex = 0
        var rightIndex = s.length - 1
        var leftIndexFound = false
        var tempChar = ' '
        val stringBuilder = StringBuilder(s)
        while (leftIndex <= rightIndex) {
            if (stringBuilder[leftIndex].isVowel() && leftIndexFound.not()) {
                tempChar = stringBuilder[leftIndex]
                leftIndexFound = true
            } else if (leftIndexFound.not()) {
                leftIndex++
            } else if (leftIndexFound && stringBuilder[rightIndex].isVowel()) {
                stringBuilder[leftIndex] = stringBuilder[rightIndex]
                stringBuilder[rightIndex] = tempChar
                leftIndex++
                rightIndex--
                leftIndexFound = false
            } else {
                rightIndex--
            }
        }
        return stringBuilder.toString()
    }

    private fun Char.isVowel(): Boolean {
        return this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u' ||
                this == 'A' || this == 'E' || this == 'I' || this == 'O' || this == 'U'
    }
}