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
        var counter = 0
        while (counter < s.size / 2) {
            val tempChar = s[s.size - 1 - counter]
            s[s.size - 1 - counter] = s[counter]
            s[counter] = tempChar
            counter++
        }
    }
}