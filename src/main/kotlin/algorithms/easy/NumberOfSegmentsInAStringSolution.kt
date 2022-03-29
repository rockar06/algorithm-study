package algorithms.easy

// https://leetcode.com/problems/number-of-segments-in-a-string
class NumberOfSegmentsInAStringSolution {

    fun countSegments(s: String): Int {
        var result = 0
        var currentWord = false

        s.forEach { character ->
            if (character != ' ' && currentWord.not()) {
                currentWord = true
                result++
            }
            currentWord = character != ' '
        }

        return result
    }
}