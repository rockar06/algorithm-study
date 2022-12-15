package algorithms.medium

import java.util.*

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii
class RemoveAllAdjacentDuplicatesInStringII {

    fun removeDuplicates(s: String, k: Int): String {
        // Problem requires to remove k duplicate removals
        // There is no constraints in space nor time
        // We need to keep a counter of each char
        // If we reach k duplicates we need to pop them if and only if they are consecutive
        // It is not a good idea to keep track the indices since we need to store them in a complex data structure
        // If we use a Pair we can keep the char and how many consecutive
        // "abcd" and k = 2 We will have the following pair representations:
        // Pair<a, 1>, Pair<b, 1>, Pair<c, 1>, Pair<d, 1>
        // No deletions required
        // "abbbcd" and k = 3
        // Pair<a, 1>, Pair<b, 1>*, Pair<b, 2>**, if next item is b and the previous char is the same the only
        // statement to evaluate if that Pair.second == k - 1, if so, delete k - 2 items from the stack
        // Pair<a, 1, Pair<b, 1>*
        // Pair<a, 1> add remaining items
        // Pair<a, 1, Pair<c, 1>, Pair<d, 1>

        val stackHelper = Stack<Pair<Char, Int>>()
        s.forEach { char ->
            if (stackHelper.isNotEmpty() && stackHelper.peek().first == char) {
                if (stackHelper.peek().second == k - 1) {
                    while (stackHelper.isNotEmpty() && stackHelper.peek().first == char) {
                        stackHelper.pop()
                    }
                } else {
                    stackHelper.push(Pair(char, stackHelper.peek().second + 1))
                }
            } else {
                stackHelper.push(Pair(char, 1))
            }
        }

        return stackHelper.joinToString("") { it.first.toString() }
    }
}