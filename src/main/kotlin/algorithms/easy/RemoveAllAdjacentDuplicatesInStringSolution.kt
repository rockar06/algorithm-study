package algorithms.easy

import java.util.*

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class RemoveAllAdjacentDuplicatesInStringSolution {
    fun removeDuplicates(s: String): String {
        val helperStack = Stack<Char>()

        s.forEach {
            if (helperStack.isNotEmpty() && helperStack.peek() == it) {
                helperStack.pop()
            } else {
                helperStack.push(it)
            }
        }
        return helperStack.joinToString("")
    }
}