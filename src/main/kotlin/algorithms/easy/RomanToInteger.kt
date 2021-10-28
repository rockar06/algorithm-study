package algorithms.easy


class RomanToInteger {

    fun romanToInt(s: String): Int {
        val romanCharMap = hashMapOf<Char, Int>().apply {
            put('I', 1)
            put('V', 5)
            put('X', 10)
            put('L', 50)
            put('C', 100)
            put('D', 500)
            put('M', 1000)
        }
        val values = arrayListOf<Int>()
        val result = arrayListOf<Int>()

        for (index in s.length - 1 downTo 0) {
            values.add(romanCharMap[s[index]] ?: 0)
        }
        var index = 0
        var nextIndex: Int
        while (index < values.size) {
            nextIndex = index.plus(1)
            if (nextIndex >= values.size || values[nextIndex] >= values[index]) {
                result.add(values[index])
                index++
            } else {
                result.add(values[index] - values[nextIndex])
                index = index.plus(2)
            }
        }

        return result.sum()
    }
}