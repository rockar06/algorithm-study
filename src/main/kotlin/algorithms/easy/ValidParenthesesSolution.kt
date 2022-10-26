package algorithms.easy

import java.util.*

//https://leetcode.com/problems/valid-parentheses/submissions/
class ValidParenthesesSolution {
    fun isValid(s: String): Boolean {
        val stackContainer = Stack<Char>()
        s.forEach { character ->
            if (character == '(' || character == '{' || character == '[') {
                stackContainer.push(character)
            } else if (stackContainer.isNotEmpty() &&
                (character == ')' && stackContainer.peek() == '(' ||
                        character == '}' && stackContainer.peek() == '{' ||
                        character == ']' && stackContainer.peek() == '[')
            ) {
                stackContainer.pop()
            } else {
                stackContainer.push(character)
            }
        }
        return stackContainer.isEmpty()
    }
    /*fun isValid(s: String): Boolean {
        val stackHelper = Stack<Char>()
        s.forEach {
            if (it == '(' || it == '{' || it == '[') {
                stackHelper.push(it)
            } else {
                if (stackHelper.isEmpty()) return false
                if (it == ')' && stackHelper.peek() == '(' ||
                    it == '}' && stackHelper.peek() == '{' ||
                    it == ']' && stackHelper.peek() == '['
                ) {
                    stackHelper.pop()
                } else {
                    return false
                }
            }
        }
        return stackHelper.isEmpty()
    }*/
}