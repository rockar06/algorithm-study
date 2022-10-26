package algorithms.easy

// https://leetcode.com/problems/longest-common-prefix/
class LongestCommonPrefixSolution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) return strs.first()
        val result = StringBuilder()
        var charCounter = 0
        while (true) {
            strs.forEachIndexed { index, character ->
                if (character.isEmpty()) {
                    return ""
                }
                if (charCounter >= character.length) {
                    if (index > 0) {
                        result.deleteCharAt(charCounter)
                    }
                    return result.toString()
                }
                if (index == 0) {
                    result.append(character[charCounter])
                } else if (character.getOrNull(charCounter) != result.last()) {
                    result.deleteCharAt(charCounter)
                    return result.toString()
                }
            }
            charCounter++
        }
    }

    /*fun longestCommonPrefix(strs: Array<String>): String {
        val resultString = StringBuilder()
        var charIndex = 0
        var index = 0
        while (index <= strs.size) {
            if (resultString.isEmpty() || index == 0) {
                if (charIndex < strs[index].length) {
                    resultString.append(strs[index][charIndex])
                    index++
                } else {
                    index = strs.size.plus(1)
                }
            } else if (index < strs.size && charIndex < strs[index].length && resultString[charIndex] == strs[index][charIndex]) {
                index++
            } else if (index == strs.size) {
                index = 0
                charIndex++
            } else {
                resultString.deleteCharAt(charIndex)
                index = strs.size.plus(1)
            }
        }
        return resultString.toString()
    }*/
}