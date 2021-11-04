package algorithms.easy

// https://leetcode.com/problems/length-of-last-word/
class LengthOfLastWordSolution {
    fun lengthOfLastWord(s: String): Int {
        var lastWordLength = 0
        var wordCounter = 0
        s.forEach {
            if (it != ' ') {
                lastWordLength = ++wordCounter
            } else {
                wordCounter = 0
            }
        }
        return lastWordLength
    }
}