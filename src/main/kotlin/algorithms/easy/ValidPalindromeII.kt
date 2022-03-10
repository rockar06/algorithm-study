package algorithms.easy

// https://leetcode.com/problems/valid-palindrome-ii/
class ValidPalindromeII {
    fun validPalindrome(s: String, skippedCounter: Int = 0): Boolean {
        var leftCounter = 0
        var rightCounter = s.length - 1
        while (leftCounter < rightCounter) {
            if (s[leftCounter] != s[rightCounter]) {
                if (skippedCounter != 0) return false
                if (validPalindrome(s.substring(leftCounter, rightCounter), 1)) return true
                if (validPalindrome(s.substring(leftCounter + 1, rightCounter + 1), 1)) return true
                return false
            } else {
                leftCounter++
                rightCounter--
            }
        }
        return true
    }
}