package algorithms.easy

class PalindromeNumberSolution {

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var aux = x
        var result = 0
        while (aux != 0) {
            result *= 10
            result += aux % 10
            aux /= 10
        }
        return result == x
    }
}