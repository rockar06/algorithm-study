package algorithms.medium

import java.util.*

// https://leetcode.com/problems/basic-calculator-ii/
class BasicCalculatorIISolution {

    fun calculate(s: String): Int {
        val helperStack = Stack<String>()
        val listOfString = arrayListOf<String>()
        val numberBuilder = StringBuilder()

        s.forEach { character ->
            if (character == '+' || character == '-' || character == '*' || character == '/') {
                listOfString.add(numberBuilder.toString())
                numberBuilder.clear()
                listOfString.add(character.toString())
            } else {
                if (character != ' ') {
                    numberBuilder.append(character)
                }
            }
        }

        listOfString.add(numberBuilder.toString())

        listOfString.forEach {
            if (helperStack.isNotEmpty() && (helperStack.peek() == "*" || helperStack.peek() == "/")) {
                val temp = if (helperStack.pop() == "*") {
                    helperStack.pop().toInt() * it.toInt()
                } else {
                    helperStack.pop().toInt() / it.toInt()
                }
                helperStack.push(temp.toString())
            } else {
                helperStack.push(it)
            }
        }

        if (helperStack.size == 1) {
            return helperStack.pop().toInt()
        }

        helperStack.reverse()
        var result = 0
        while (helperStack.isNotEmpty()) {
            when (val lastChar = helperStack.pop()) {
                "+" -> {
                    result += helperStack.pop().toInt()
                }
                "-" -> {
                    result -= helperStack.pop().toInt()
                }
                else -> {
                    result = lastChar.toInt()
                }
            }
        }
        return result
    }
}