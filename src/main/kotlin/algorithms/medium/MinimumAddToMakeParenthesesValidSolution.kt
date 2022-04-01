package algorithms.medium

import java.util.*

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class MinimumAddToMakeParenthesesValidSolution {

    fun minAddToMakeValid(s: String): Int {
        val helperStack = Stack<Char>()
        s.forEach {
            if (it == ')' && helperStack.isNotEmpty() && helperStack.peek() == '(') {
                helperStack.pop()
            } else {
                helperStack.push(it)
            }
        }

        return helperStack.size
    }
}
