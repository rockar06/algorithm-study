package algorithms.easy

// https://leetcode.com/problems/valid-perfect-square
class ValidPerfectSquareSolution {
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) return true
        var counter = 2
        while (counter < num) {
            when(counter * counter) {
                0 -> return false
                num -> return true
            }
            counter++
        }
        return false
    }
}
