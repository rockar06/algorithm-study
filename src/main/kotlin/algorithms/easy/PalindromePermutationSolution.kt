package algorithms.easy

// https://leetcode.com/problems/palindrome-permutation
class PalindromePermutationSolution {

    fun canPermutePalindrome(s: String): Boolean {
        val characterMapper = IntArray(26)
        var oddNumbers = 0

        s.forEach {
            characterMapper[it - 'a']++
        }

        characterMapper.forEach {
            if (it % 2 != 0) {
                oddNumbers++
            }
        }

        return oddNumbers <= 1
    }
}