package algorithms.easy

// https://leetcode.com/problems/palindrome-number
class PalindromeNumberSolution {

    fun isPalindrome(x: Int): Boolean {
        var newValue = x
        var result = 0
        while (newValue > 0) {
            result =+ (result * 10) + (newValue % 10)
            newValue /= 10
        }
        return result == x
    }
}