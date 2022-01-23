package algorithms.easy

// https://leetcode.com/problems/add-strings/
class AddStringsSolution {

    fun addStrings(num1: String, num2: String): String {
        var valueA = num1
        var valueB = num2
        val stringBuilder = StringBuilder()
        val maxLength = Math.max(valueA.length, valueB.length)
        var carry = 0

        val differenceInLength = Math.abs(valueA.length - valueB.length)
        if (valueA.length > valueB.length) {
            valueB = valueB.padStart(differenceInLength + valueB.length, ' ')
        } else {
            valueA = valueA.padStart(differenceInLength + valueA.length, ' ')
        }

        for (index in maxLength - 1 downTo 0) {
            val result = if (valueA[index] == ' ') {
                performAdd(0, Character.getNumericValue(valueB[index]), carry)
            } else if (valueB[index] == ' ') {
                performAdd(Character.getNumericValue(valueA[index]), 0, carry)
            } else {
                performAdd(Character.getNumericValue(valueA[index]), Character.getNumericValue(valueB[index]), carry)
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
        val add = firstNumber + secondNumber + carry
        val newCarry = add / 10
        val value = add % 10
        return Pair(newCarry, value)
    }
}