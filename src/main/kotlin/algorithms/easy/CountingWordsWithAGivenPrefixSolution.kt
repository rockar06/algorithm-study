package algorithms.easy

// https://leetcode.com/problems/counting-words-with-a-given-prefix
class CountingWordsWithAGivenPrefixSolution {

    fun prefixCount(words: Array<String>, pref: String): Int {
        var counter = 0
        words.forEach {
            var wordPointer = 0
            while (wordPointer < pref.length && wordPointer < it.length && pref[wordPointer] == it[wordPointer]) {
                wordPointer++
            }
            if (wordPointer == pref.length) {
                counter++
            }
        }
        return counter
    }
}