package algorithms.easy

// https://leetcode.com/problems/valid-word-abbreviation/
class ValidWordAbbreviationSolution {

    // "internationalization", abbr = "i12iz4n"
    /*fun validWordAbbreviation(word: String, abbr: String): Boolean {
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
    }*/

    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        var wordIndex = 0
        var abbreviationIndex = 0
        while (wordIndex < word.length) {
            if (abbr.getOrNull(abbreviationIndex) in '1'..'9') {
                val valuesToAdd = getAbbreviationNumber(abbr, abbreviationIndex)
                abbreviationIndex += valuesToAdd.first
                wordIndex += valuesToAdd.second
            }
            if (word.getOrNull(wordIndex) != abbr.getOrNull(abbreviationIndex)) return false
            if (wordIndex < word.length) {
                wordIndex++
                abbreviationIndex++
            }
        }
        return wordIndex == word.length && abbreviationIndex == abbr.length
    }

    private fun getAbbreviationNumber(abbreviation: String, startIndex: Int): Pair<Int, Int> {
        var abbrCounter = startIndex
        val numberBuilder = StringBuilder()
        while (abbrCounter < abbreviation.length && abbreviation[abbrCounter] in '0'..'9') {
            numberBuilder.append(abbreviation[abbrCounter])
            abbrCounter++
        }
        return Pair(numberBuilder.toString().length, numberBuilder.toString().toInt())
    }
}