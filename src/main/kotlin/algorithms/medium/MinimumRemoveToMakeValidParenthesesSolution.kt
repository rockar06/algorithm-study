package algorithms.medium

import java.util.*

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
class MinimumRemoveToMakeValidParenthesesSolution {

    fun minRemoveToMakeValid(s: String): String {
        val helperStack = Stack<Int>()
        s.forEachIndexed { index, value ->
            if (value == ')' && helperStack.isNotEmpty() && s[helperStack.peek()] == '(') {
                helperStack.pop()
            } else if (value == '(' || value == ')') {
                helperStack.push(index)
            }
        }

        if (helperStack.isEmpty()) {
            return s
        }

        val result = StringBuilder()
        val helperQueue: Queue<Int> = LinkedList(helperStack)

        s.forEachIndexed { index, value ->
            if (index == helperQueue.peek()) {
                helperQueue.poll()
            } else {
                result.append(value)
            }
        }

        return result.toString()
    }
}
