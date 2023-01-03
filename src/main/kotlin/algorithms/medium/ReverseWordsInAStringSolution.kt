package algorithms.medium

// https://leetcode.com/problems/reverse-words-in-a-string
class ReverseWordsInAStringSolution {

    fun reverseWords(s: String): String {
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

        for (index in listOfWords.lastIndex downTo 0) {
            wordBuilder.append(listOfWords[index])
            if (index != 0) {
                wordBuilder.append(" ")
            }
        }

        return wordBuilder.toString()
    }
}