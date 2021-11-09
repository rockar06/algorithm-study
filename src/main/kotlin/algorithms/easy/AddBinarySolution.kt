package algorithms.easy

// https://leetcode.com/problems/add-binary/
class AddBinarySolution {
    fun addBinary(a: String, b: String): String {
        val stringBuilderResult = StringBuilder()
        val reversedA = a.reversed()
        val reversedB = b.reversed()
        val sizeA = a.length
        val sizeB = b.length
        var carried = false
        val largestSize = if (sizeA > sizeB) sizeA else sizeB
        var index = 0
        var digitA: Char
        var digitB: Char
        while (index <= largestSize) {
            digitA = if (index >= sizeA) '0' else reversedA[index]
            digitB = if (index >= sizeB) '0' else reversedB[index]

            if (carried && digitA == '1' && digitB == '1') {
                stringBuilderResult.append('1')
            } else if (digitA == '1' && digitB == '1') {
                stringBuilderResult.append('0')
                carried = true
            } else if (carried && digitA == '0' && digitB == '0') {
                stringBuilderResult.append('1')
                carried = false
            } else if (carried && (digitA == '1' && digitB == '0' || digitA == '0' && digitB == '1')) {
                stringBuilderResult.append('0')
                carried = true
            } else if (digitA == '1' && digitB == '0' || digitA == '0' && digitB == '1') {
                stringBuilderResult.append('1')
            } else if (index != largestSize){
                stringBuilderResult.append('0')
            }
            index++
        }
        return stringBuilderResult.reverse().toString()
    }
}