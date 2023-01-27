package algorithms.easy

// https://leetcode.com/problems/longest-common-prefix/
class LongestCommonPrefixSolution {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        val prefix = StringBuilder(strs.first())

        for (index in 1 .. strs.lastIndex) {
            while (strs[index].indexOf(prefix.toString()) != 0) {
                prefix.deleteCharAt(prefix.lastIndex)
                if (prefix.isEmpty()) return ""
            }
        }

        return prefix.toString()
    }
}