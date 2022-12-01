package algorithms.medium

import java.lang.Character.getNumericValue

// https://leetcode.com/problems/multiply-strings/
class MultiplyStringSolution {

    fun multiply(num1: String, num2: String): String {

        if (num1 == "0" || num2 == "0") {
            return "0"
        }

        // Multiply each item from num1 with num2 (as normal multiplication)
        // We need to iterate item by item, that means we need to have a nested loop based on the size of num1 and num2
        // Use a builder string to add items based on each multiplication
        // Add an extra zero based on the index to keep the space of the multiplication process
        // Keep track on the carry number as an extra array
        // Reverse the string and save it in an array
        // Repeat until iterate all items

        val sumRowArray = mutableListOf<String>()
        val topNumber: String
        val bottomNumber: String
        var multiplyCarry = 0

        if (num1.length >= num2.length) {
            topNumber = num1
            bottomNumber = num2
        } else {
            topNumber = num2
            bottomNumber = num1
        }

        var bottomCounter = bottomNumber.lastIndex
        var topCounter = topNumber.lastIndex

        val tailingZerosString = StringBuilder()

        var largerStringLength = 0

        while (bottomCounter >= 0) {
            val rowStringBuilder = StringBuilder()
            rowStringBuilder.append(tailingZerosString)
            while (topCounter >= 0) {
                val addResult = performTimes(
                    getNumericValue(bottomNumber[bottomCounter]),
                    getNumericValue(topNumber[topCounter]),
                    multiplyCarry
                )
                multiplyCarry = addResult.first
                rowStringBuilder.append(addResult.second)
                topCounter--
            }

            if (multiplyCarry > 0) {
                rowStringBuilder.append(multiplyCarry)
            }
            tailingZerosString.append("0")
            sumRowArray.add(rowStringBuilder.toString())
            largerStringLength = sumRowArray.last().length
            multiplyCarry = 0

            topCounter = topNumber.lastIndex
            bottomCounter--
        }

        // Sum all the strings to get final result
        // Iterate over all the strings to get item by item, then make the sum

        var sumCounter = 0
        var additionCarry = 0
        val stringResult = StringBuilder()

        while (sumCounter < largerStringLength) {

            var getColumnSum = sumRowArray.sumOf { currentArray ->
                currentArray.getOrNull(sumCounter)?.let {
                    getNumericValue(it)
                } ?: 0
            }

            getColumnSum += additionCarry

            additionCarry = getColumnSum / 10

            stringResult.append(getColumnSum % 10)

            sumCounter++
        }

        if(additionCarry > 0) {
            stringResult.append(additionCarry)
        }

        return stringResult.reverse().toString()
    }

    private fun performTimes(firstNumber: Int, secondNumber: Int, carry: Int): Pair<Int, Int> {
        var resultSum = (firstNumber * secondNumber) + carry
        val newCarry = resultSum / 10
        resultSum %= 10
        return Pair(newCarry, resultSum)
    }
}