package algorithms.easy

// https://leetcode.com/problems/split-strings-by-separator/description/
class SplitStringsBySeparatorSolution {

    fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {
        val wordBuilder = StringBuilder()
        val result = mutableListOf<String>()
        for (word in words) {
            word.forEach { char ->
                if (char == separator) {
                    if (wordBuilder.length != 0) {
                        result.add(wordBuilder.toString())
                        wordBuilder.setLength(0)
                    }
                } else {
                    wordBuilder.append(char)
                }
            }
            if (wordBuilder.length != 0) {
                result.add(wordBuilder.toString())
                wordBuilder.setLength(0)
            }
        }
        return result
    }
}