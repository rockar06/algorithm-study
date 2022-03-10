package algorithms.easy

// https://leetcode.com/problems/valid-palindrome/submissions/
class ValidPalindromeSolution {
    fun isPalindrome(s: String): Boolean {
        val lowerCaseRange = 'a'..'z'
        val upperCaseRange = 'A'..'Z'
        val digitsRange = '0'..'9'
        val cleanString = StringBuilder()
        s.forEach {
            if (it in lowerCaseRange || it in upperCaseRange || it in digitsRange) {
                cleanString.append(it.lowercaseChar())
            }
        }

        if (cleanString.isEmpty()) {
            return true
        }

        val totalSize = cleanString.length - 1
        var index = 0
        while (index <= totalSize / 2) {
            if (cleanString[index] != cleanString[totalSize - index]) {
                return false
            }
            index++
        }

        return true
    }
}