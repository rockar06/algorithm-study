package algorithms.easy

// https://leetcode.com/problems/rotate-string/
class RotateStringSolution {

    fun rotateString(s: String, goal: String): Boolean {
        // first remove the first digit of the string, then add it to the end
        // compare with goal, if it is equal, return true otherwise continue the process of replacement
        // if we circle the whole string and there is no match, return false
        // how to know when we circled the string?
        // we can use a counter and when we reach the size of the string, means we are circled the string
        // If we loop the string "s" and we add at the end of resultBuild the char and drop the first char, after
        // iterating the whole string we can break the loop
        if (s == goal) return true

        val resultBuilder = StringBuilder(s)

        s.forEach { char ->
            resultBuilder.apply {
                deleteCharAt(0)
                append(char)
            }
            if (resultBuilder.toString() == goal) {
                return true
            }
        }

        return false
    }
}