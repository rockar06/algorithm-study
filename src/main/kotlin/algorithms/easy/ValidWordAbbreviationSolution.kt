package algorithms.easy

// https://leetcode.com/problems/valid-word-abbreviation/
class ValidWordAbbreviationSolution {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        if (abbr.length > word.length) return false
        var counter = 0
        var abbrCounter = 0

        while (counter < word.length && abbrCounter < abbr.length) {
            if (abbr[abbrCounter] in '1'..'9') {
                val result = getNumberOfCharacters(abbr, abbrCounter)
                counter += result.first
                abbrCounter += result.second
                if (word.getOrNull(counter) != abbr.getOrNull(abbrCounter)) {
                    return false
                }
            } else {
                if (word.getOrNull(counter) != abbr.getOrNull(abbrCounter)) {
                    return false
                }
                abbrCounter++
                counter++
            }
        }
        return counter == word.length && abbrCounter == abbr.length
    }

    private fun getNumberOfCharacters(abbr: String, counter: Int): Pair<Int, Int> {
        var abbrCounter = 0
        val numberBuilder = StringBuilder()
        while (counter + abbrCounter < abbr.length && abbr[counter + abbrCounter] in '0'..'9') {
            numberBuilder.append(abbr[counter + abbrCounter])
            abbrCounter++
        }
        return Pair(numberBuilder.toString().toInt(), abbrCounter)
    }
}