package algorithms.easy

// https://leetcode.com/problems/plus-one/submissions/
class PlusOneSolution {
    fun plusOne(digits: IntArray): IntArray {
        var carriedDigit = false
        var index = digits.size - 1
        var additionResult: Int
        while (index >= 0) {
            additionResult = digits[index].plus(1).apply {
                carriedDigit = this > 9
            }
            additionResult = if (carriedDigit) 0 else additionResult
            digits[index] = additionResult
            if (carriedDigit) {
                index--
            } else {
                return digits
            }
        }
        return if (carriedDigit) {
            val resultDigits = IntArray(digits.size + 1)
            resultDigits[0] = 1
            digits.forEachIndexed { digitsIndex, value ->
                resultDigits[digitsIndex + 1] = value
            }
            resultDigits
        } else {
            digits
        }
    }
}