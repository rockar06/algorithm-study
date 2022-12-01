package algorithms.easy

// https://leetcode.com/problems/plus-one/submissions/
class PlusOneSolution {
    /*fun plusOne(digits: IntArray): IntArray {
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
    }*/

    fun plusOne(digits: IntArray): IntArray {
        var rightPointer = digits.lastIndex
        var carryItem = 0

        val currentSum = digits[rightPointer] + 1
        carryItem = currentSum / 10
        digits[rightPointer--] = currentSum % 10

        while (carryItem > 0 && rightPointer >= 0) {

            val carrySum = digits[rightPointer] + carryItem
            carryItem = carrySum / 10
            digits[rightPointer] = carrySum % 10

            rightPointer--
        }

        return if (carryItem > 0) {
            intArrayOf(carryItem) + digits
        } else {
            digits
        }
    }
}