package algorithms.easy

import java.lang.Character.getNumericValue

// https://leetcode.com/problems/add-strings/
class AddStringsSolution {

    fun addStrings(num1: String, num2: String): String {
        var counterA = num1.length - 1
        var counterB = num2.length - 1
        val stringBuilder = StringBuilder()
        var carry = 0

        while (counterA >= 0 || counterB >= 0) {
            val result = if (counterA < 0) {
                performAdd(0, getNumericValue(num2[counterB--]), carry)
            } else if (counterB < 0) {
                performAdd(getNumericValue(num1[counterA--]), 0, carry)
            } else {
                performAdd(getNumericValue(num1[counterA--]), getNumericValue(num2[counterB--]), carry)
            }
            carry = result.first
            stringBuilder.append(result.second)
        }

        if (carry > 0) {
            stringBuilder.append(carry)
        }
        return stringBuilder.reverse().toString()
    }

    private fun performAdd(firstNumber: Int, secondNumber: Int, carry: Int): Pair<Int, Int> {
        var resultSum = firstNumber + secondNumber + carry
        val newCarry = resultSum / 10
        resultSum %= 10
        return Pair(newCarry, resultSum)
    }
}