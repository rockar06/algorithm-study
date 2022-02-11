package algorithms.easy

import java.util.*

//https://leetcode.com/problems/valid-parentheses/submissions/
class ValidParenthesesSolution {
    fun isValid(s: String): Boolean {
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
    }
}