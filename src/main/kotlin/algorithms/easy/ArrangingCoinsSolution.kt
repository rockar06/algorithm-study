package algorithms.easy

// https://leetcode.com/problems/arranging-coins/submissions/
class ArrangingCoinsSolution {

    fun arrangeCoins(n: Int): Int {
        var coinsCounter = n
        var rowCounter = 1

        while (rowCounter < n) {
            coinsCounter -= rowCounter

            if (coinsCounter == 0) {
                return rowCounter
            }
            if (coinsCounter < 0) {
                return rowCounter - 1
            }
            rowCounter++
        }
        return 0
    }
}

