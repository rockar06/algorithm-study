package algorithms.easy

// https://leetcode.com/problems/valid-palindrome/submissions/
class ValidPalindromeSolution {
    fun isPalindrome(s: String): Boolean {
        val lowerCaseRange = 65..90
        val upperCaseRange = 97..122
        val digitsRange = 48..57
        val cleanString = StringBuilder()
        s.forEach {
            if (it.code in lowerCaseRange || it.code in upperCaseRange || it.code in digitsRange) {
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