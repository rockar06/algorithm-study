package algorithms.medium

import java.util.*

// https://leetcode.com/problems/basic-calculator-ii/
class BasicCalculatorIISolution {

    fun calculate(s: String): Int {

        var result = 0
        var currentNumber = 0
        var currentOperation = '+'
        val resultStack = Stack<Int>()

        for (index in s.indices) {
            if (s[index].isDigit()) {
                currentNumber = (currentNumber * 10) + (s[index] - '0')
            }
            if (!s[index].isDigit() && !s[index].isWhitespace() || index == s.lastIndex) {
                when (currentOperation) {
                    '-' -> {
                        resultStack.push(-currentNumber)
                    }
                    '+' -> {
                        resultStack.push(currentNumber)
                    }
                    '*' -> {
                        resultStack.push(resultStack.pop() * currentNumber)
                    }
                    else -> {
                        resultStack.push(resultStack.pop() / currentNumber)
                    }
                }
                currentOperation = s[index]
                currentNumber = 0
            }
        }

        while (resultStack.isNotEmpty()) {
            result += resultStack.pop()
        }

        return result
    }
}