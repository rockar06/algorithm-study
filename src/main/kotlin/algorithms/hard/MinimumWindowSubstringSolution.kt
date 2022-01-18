package algorithms.hard

// https://leetcode.com/problems/minimum-window-substring
class MinimumWindowSubstringSolution {

    fun minWindow(s: String, t: String): String {
        var result = ""
        val wordCharArray = IntArray(58)
        val charArray = IntArray(58)
        t.forEach {
            charArray[it - 'A']++
        }
        var leftIndex = 0
        var rightIndex = 0

        while (leftIndex < s.length) {
            if (containsWindow(wordCharArray, charArray)) {
                if (result.isEmpty() || (rightIndex - leftIndex) < result.length) {
                    result = s.substring(leftIndex, rightIndex)
                }
                wordCharArray[s[leftIndex] - 'A']--
                leftIndex++
            } else {
                if (rightIndex >= s.length) {
                    leftIndex = s.length
                } else {
                    wordCharArray[s[rightIndex] - 'A']++
                    rightIndex++
                }
            }
        }

        return result
    }

    private fun containsWindow(wordCharArray: IntArray, charArray: IntArray): Boolean {
        for (index in 0 until 58) {
            if (charArray[index] > wordCharArray[index]) return false
        }
        return true
    }
}
