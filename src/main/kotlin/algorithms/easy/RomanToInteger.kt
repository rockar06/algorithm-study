package algorithms.easy

// https://leetcode.com/problems/roman-to-integer
class RomanToInteger {

    private val romanNumerals = hashMapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    fun romanToInt(s: String): Int {
        var counter = s.length - 1
        var result = 0
        while (counter >= 0) {
            if (romanNumerals.getOrDefault(s[counter], 0) > romanNumerals.getOrDefault(s.getOrNull(counter - 1), 0)) {
                result += romanNumerals.getOrDefault(s[counter], 0) - romanNumerals.getOrDefault(s.getOrNull(counter - 1), 0)
                counter -= 2
            } else {
                result += romanNumerals.getOrDefault(s[counter--], 0)
            }
        }
        return result
    }
}