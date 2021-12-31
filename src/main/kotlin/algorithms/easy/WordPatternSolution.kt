package algorithms.easy

// https://leetcode.com/problems/word-pattern/
class WordPatternSolution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val segmentedString = s.split(" ")
        if (pattern.length != segmentedString.size) return false
        val charMap = hashMapOf<Char, String>()
        pattern.forEachIndexed { index, c ->
            if ((charMap[c] != null && charMap[c] != segmentedString[index]) ||
                (charMap.containsValue(segmentedString[index]) && c != charMap.keys.firstOrNull { it == c })
            ) {
                return false
            } else {
                charMap[c] = segmentedString[index]
            }
        }
        return true
    }
}