package algorithms.easy

// https://leetcode.com/problems/number-complement
class NumberComplementSolution {

    fun findComplement(num: Int): Int {
        val binaryString = Integer.toBinaryString(num)
        val stringBuilder = StringBuilder(binaryString.length)
        binaryString.forEach {
            if (it == '1') {
                stringBuilder.append('0')
            } else {
                stringBuilder.append('1')
            }
        }
        return Integer.parseInt(stringBuilder.toString(), 2)
    }
}