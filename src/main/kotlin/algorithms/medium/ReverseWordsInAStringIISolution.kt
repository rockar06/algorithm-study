package algorithms.medium

// https://leetcode.com/problems/reverse-words-in-a-string-ii
class ReverseWordsInAStringIISolution {

    fun reverseWords(s: CharArray): Unit {
        val wordBuilder = StringBuilder()
        val listOfWords = mutableListOf<String>()

        s.forEach {
            if (it == ' ' && wordBuilder.isNotEmpty()) {
                listOfWords.add(wordBuilder.toString())
                wordBuilder.clear()
            } else if (it != ' ') {
                wordBuilder.append(it)
            }
        }

        if (wordBuilder.isNotEmpty()) {
            listOfWords.add(wordBuilder.toString())
            wordBuilder.clear()
        }

        var charIndex = 0
        for (index in listOfWords.lastIndex downTo 0) {
            listOfWords[index].forEach {
                s[charIndex++] = it
            }
            if (index != 0) {
                s[charIndex++] = ' '
            }
        }
    }
}