package algorithms.easy

// https://leetcode.com/problems/roman-to-integer
class RomanToInteger {

    private val numbersMap = hashMapOf<Char, Int>().apply {
        put('I', 1)
        put('V', 5)
        put('X', 10)
        put('L', 50)
        put('C', 100)
        put('D', 500)
        put('M', 1000)
    }

    fun romanToInt(s: String): Int {

        var result = 0
        var index = s.length - 1
        while (index >= 0) {
            if ((index - 1) >= 0 &&
                numbersMap.getOrDefault(s[index - 1], 0) < numbersMap.getOrDefault(s[index], 0)
            ) {
                result += numbersMap.getOrDefault(s[index], 0) - numbersMap.getOrDefault(s[index - 1], 0)
                index -= 2
            } else {
                result += numbersMap.getOrDefault(s[index], 0)
                index--
            }
        }
        return result
    }
}