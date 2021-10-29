package algorithms.easy

import java.util.*

//https://leetcode.com/problems/valid-parentheses/submissions/
class ValidParenthesesSolution {
    fun isValid(s: String): Boolean {
        val stackChar = Stack<Char>()
        var index = 0
        while (index < s.length) {
            if (s[index] == '(' || s[index] == '[' || s[index] == '{') {
                stackChar.push(s[index])
                index++
            } else if (stackChar.isNotEmpty() && (s[index] == ')' && stackChar.peek() == '('
                        || s[index] == ']' && stackChar.peek() == '['
                        || s[index] == '}' && stackChar.peek() == '{')
            ) {
                stackChar.pop()
                index++
            } else {
                stackChar.push(s[index])
                index = s.length
            }
        }
        return stackChar.isEmpty()
    }
}