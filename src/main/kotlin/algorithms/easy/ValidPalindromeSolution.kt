package algorithms.easy

// https://leetcode.com/problems/valid-palindrome/submissions/
class ValidPalindromeSolution {
    fun isPalindrome(s: String): Boolean {
        val cleanString = arrayListOf<Char>()
        s.forEach {
            if (it.isLetterOrDigit()) {
                cleanString.add(it.lowercaseChar())
            }
        }

        if (cleanString.isEmpty()) {
            return true
        }

        val totalSize = cleanString.lastIndex
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