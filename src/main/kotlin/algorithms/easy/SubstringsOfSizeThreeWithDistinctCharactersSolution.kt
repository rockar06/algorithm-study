package algorithms.easy

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
class SubstringsOfSizeThreeWithDistinctCharactersSolution {

    fun countGoodSubstrings(s: String): Int {
        var numberOfDistinctSubstrings = 0
        var leftPointer = 0
        var rightPointer = 0
        val charactersContainer = IntArray(26)
        while (leftPointer <= s.length - 3) {
            charactersContainer[s[rightPointer] - 'a']++
            if ((rightPointer + 1) - leftPointer == 3) {
                if (stringContainsOnlyDistinct(charactersContainer)) {
                    numberOfDistinctSubstrings++
                }
                charactersContainer[s[leftPointer++] - 'a']--
            }
            rightPointer++
        }
        return numberOfDistinctSubstrings
    }

    private fun stringContainsOnlyDistinct(charactersContainer: IntArray): Boolean {
        charactersContainer.forEach {
            if (it > 1) return false
        }
        return true
    }
}