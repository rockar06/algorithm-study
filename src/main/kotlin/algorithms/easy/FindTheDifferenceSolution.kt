package algorithms.easy

// https://leetcode.com/problems/find-the-difference
class FindTheDifferenceSolution {

    fun findTheDifference(s: String, t: String): Char {
        val arrayS = IntArray(26)
        val arrayT = IntArray(26)
        s.forEach {
            arrayS[it - 'a']++
        }
        t.forEach {
            arrayT[it -'a']++
        }
        for (index in 0 until 26) {
            if (arrayS[index] != arrayT[index]) return (index + 'a'.toInt()).toChar()
        }
        return ' '
    }
}