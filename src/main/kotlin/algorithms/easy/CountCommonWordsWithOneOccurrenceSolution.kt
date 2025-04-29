package algorithms.easy

// https://leetcode.com/problems/count-common-words-with-one-occurrence/description/
class CountCommonWordsWithOneOccurrenceSolution {

    fun countWords(words1: Array<String>, words2: Array<String>): Int {
        val words1Map = hashMapOf<String, Int>()
        words1.forEach { word ->
            words1Map[word] = (words1Map[word] ?: 0) + 1
        }
        val words2Map = hashMapOf<String, Int>()
        words2.forEach { word ->
            words2Map[word] = (words2Map[word] ?: 0) + 1
        }
        val resultArray = arrayListOf<String>()

        words1Map.forEach { (word, count) ->
            if (count == 1 && words2Map.containsKey(word) && words2Map[word] == 1) {
                resultArray.add(word)
            }
        }
        return resultArray.size
    }
}