package algorithms.easy

// https://leetcode.com/problems/valid-word-abbreviation/
class ValidWordAbbreviationSolution {

    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        if (abbr.length > word.length) return false

        var extraIndices = 0
        var index = 0
        val digitBuilder = StringBuilder()

        while (index < abbr.length) {
            if (abbr[index].isDigit()) {
                if (digitBuilder.isEmpty() && abbr[index] == '0') return false
                digitBuilder.append(abbr[index])
            } else {
                if (digitBuilder.isNotEmpty()) {
                    extraIndices += digitBuilder.toString().toInt() - digitBuilder.length
                    digitBuilder.clear()
                }
                if (index + extraIndices >= word.length || abbr[index] != word[index + extraIndices]) {
                    return false
                }
            }
            index++
        }

        if (digitBuilder.isNotEmpty()) {
            extraIndices += digitBuilder.toString().toInt() - digitBuilder.length
        }

        return word.length == index + extraIndices
    }
}