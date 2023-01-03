package algorithms.easy

// https://leetcode.com/problems/reverse-words-in-a-string-iii
class ReverseWordsInAStringIIISolution {

    fun reverseWords(s: String): String {
        val resultBuilder = StringBuilder(s.length)
        val listOfWords = s.split(" ")
        listOfWords.forEachIndexed { index, word ->
            val reversedText = word.reversed()
            resultBuilder.append(reversedText)
            if (index < listOfWords.lastIndex) {
                resultBuilder.append(' ')
            }
        }
        return resultBuilder.toString()
    }
}