package algorithms.easy

// https://leetcode.com/problems/reverse-string/
class ReverseStringSolution {
    /*fun reverseString(s: CharArray) {
        reverseByPosition(
            s,
            s[0],
            s[s.size - 1],
            0
        )
    }

    private fun reverseByPosition(charArray: CharArray, charA: Char, charB: Char, addingPosition: Int) {
        if (addingPosition >= (charArray.size / 2)) return
        charArray[0 + addingPosition] = charB
        charArray[charArray.size - (1 + addingPosition)] = charA
        reverseByPosition(
            charArray,
            charArray[0 + (addingPosition + 1)],
            charArray[charArray.size - (1 + (addingPosition + 1))],
            addingPosition + 1
        )
    }*/

    fun reverseString(s: CharArray) {
        var leftIndex = 0
        var rightIndex = s.size - 1
        while (leftIndex < rightIndex) {
            val tempChar = s[rightIndex]
            s[rightIndex--] = s[leftIndex]
            s[leftIndex++] = tempChar
        }
    }
}