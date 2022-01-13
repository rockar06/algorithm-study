package algorithms.medium

// https://leetcode.com/problems/permutation-in-string/
class PermutationInStringSolution {

    private val permutationsMap = hashMapOf<String, Int>()

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        permute(s1, 0, s1.length - 1)
        var firstIndex = 0
        var lastIndex = s1.length
        while (lastIndex <= s2.length) {
            if (permutationsMap[s2.substring(firstIndex, lastIndex)] == 1) return true
            firstIndex++
            lastIndex++
        }
        return false
    }

    private fun permute(resource: String, startIndex: Int, endIndex: Int) {
        var str: String = resource
        if (startIndex == endIndex) {
            permutationsMap[str] = 1
        } else {
            for (i in startIndex..endIndex) {
                str = swap(str, startIndex, i)
                permute(str, startIndex + 1, endIndex)
                str = swap(str, startIndex, i)
            }
        }
    }

    private fun swap(resource: String, startIndex: Int, endIndex: Int): String {
        val temp: Char
        val charArray = resource.toCharArray()
        temp = charArray[startIndex]
        charArray[startIndex] = charArray[endIndex]
        charArray[endIndex] = temp
        return String(charArray)
    }
}