package algorithms.medium

import java.util.*

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
class MinimumRemoveToMakeValidParenthesesSolution {

    fun minRemoveToMakeValid(s: String): String {
        val result = StringBuilder(s)
        val helperStack = Stack<Pair<Char, Int>>()
        result.forEachIndexed { index, character ->
            if (character == '(') {
                helperStack.push(Pair(character, index))
            }
            if (character == ')') {
                if (helperStack.isNotEmpty() && helperStack.peek().first == '(') {
                    helperStack.pop()
                } else {
                    helperStack.push(Pair(character, index))
                }
            }
        }

        for (index in result.lastIndex downTo 0) {
            if (helperStack.isNotEmpty() && helperStack.peek().second == index) {
                result[helperStack.pop().second] = '_'
            }
        }

        return result.toString().replace("_", "")
    }
}
