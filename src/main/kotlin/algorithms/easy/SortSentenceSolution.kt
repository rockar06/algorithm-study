package algorithms.easy

// https://leetcode.com/problems/sorting-the-sentence/description/
class SortSentenceSolution {

    fun sortSentence(s: String): String {
        val stringContainer = mutableListOf<Pair<Int, String>>()

        val wordBuilder = StringBuilder()
        var wordNumber = 0

        s.forEach {
            if (it.isWhitespace()) {
                val wordToAdd = wordBuilder.toString()
                stringContainer.add(Pair(wordNumber, wordToAdd))
                wordBuilder.clear()
            } else if (it.isDigit()) {
                wordNumber = it.toInt()
            } else {
                wordBuilder.append(it)
            }
        }

        val wordToAdd = wordBuilder.toString()
        stringContainer.add(Pair(wordNumber, wordToAdd))
        wordBuilder.clear()

        stringContainer.sortBy {
            it.first
        }

        stringContainer.forEachIndexed { index, pair ->
            wordBuilder.append(pair.second)
            if (index < stringContainer.lastIndex) {
                wordBuilder.append(" ")
            }
        }

        return wordBuilder.toString()
    }
}