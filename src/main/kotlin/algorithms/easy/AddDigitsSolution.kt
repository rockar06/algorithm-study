package algorithms.easy

// https://leetcode.com/problems/add-digits/
class AddDigitsSolution {
    fun addDigits(num: Int): Int {
        var tempNum = num
        var result = 0
        while (tempNum > 0) {
            result += tempNum % 10
            tempNum /= 10
            if (tempNum == 0 && result / 10 != 0) {
                tempNum = result
                result = 0
            }
        }
        return result
    }
}