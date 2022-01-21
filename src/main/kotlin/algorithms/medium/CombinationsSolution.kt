package algorithms.medium

class CombinationsSolution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        return combineNumbers(n, k)
    }

    private fun combineNumbers(
        totalNumbers: Int,
        maxCombinations: Int,
        currentIndex: Int = 1,
        itemNumber: Int = 0,
        counterCombinations: Int = 0,
        rowArray: MutableList<Int> = mutableListOf(),
        resultArray: MutableList<List<Int>> = mutableListOf()
    ): List<List<Int>> {
        return if (currentIndex <= totalNumbers && counterCombinations < maxCombinations) {
            rowArray.add(itemNumber + 1)
            combineNumbers(totalNumbers, maxCombinations, currentIndex, itemNumber + 1, counterCombinations + 1, rowArray, resultArray)
        } else if (currentIndex <= totalNumbers && counterCombinations == maxCombinations) {
            resultArray.add(rowArray)
            combineNumbers(totalNumbers, maxCombinations, currentIndex, itemNumber + 1, resultArray = resultArray)
        } else if (currentIndex > totalNumbers) {
            resultArray.add(rowArray)
            combineNumbers(totalNumbers, maxCombinations, currentIndex + 1, resultArray = resultArray)
        } else {
            resultArray
        }
    }
}

fun main() {
    val result = CombinationsSolution().combine(4, 2)
}