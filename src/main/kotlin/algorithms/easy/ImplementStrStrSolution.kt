package algorithms.easy

// https://leetcode.com/problems/implement-strstr/submissions/
class ImplementStrStrSolution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        var indexWhenMatch = 0
        var haystackIndex = 0
        var needleIndex = 0
        while (indexWhenMatch < haystack.length && needleIndex < needle.length) {
            if (haystack[indexWhenMatch] == needle[needleIndex]) {
                indexWhenMatch++
                needleIndex++
            } else {
                indexWhenMatch = ++haystackIndex
                needleIndex = 0
            }
        }
        return if (needleIndex == needle.length) haystackIndex else -1
    }
}